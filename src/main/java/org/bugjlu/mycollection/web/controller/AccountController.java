package org.bugjlu.mycollection.web.controller;


import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.service.ContentService;
import org.bugjlu.mycollection.service.TagService;
import org.bugjlu.mycollection.web.vo.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ContentService contentService;

    @Autowired
    TagService tagService;

    @RequestMapping(value = "followee.html")
    public String followee(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "关注的人");
        request.setAttribute("list", "followee");
        List<User> result = new ArrayList<User>(user.getFollowee());
        request.setAttribute("result", result);
        return "account/searchuser";
    }

    @RequestMapping(value="account.html")
    public String account(HttpServletRequest request)
    {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "用户信息");
        String email = request.getParameter("email");
        User show;
        if(email == null ||
                email.equals(user.getEmail())) {
            show = user;
        } else {
            show = accountService.queryByEmail(email);
//            show = accountService.get;
            if (show == null) {
                return "redirect: index.html";
            }
        }
        request.setAttribute("show", show);
        return "account/account";
    }

    @RequestMapping(value="updateinfo.html")
    public String updateInfo(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "修改信息");
        return "account/updateinfo";
    }

    @RequestMapping(value = "updateact.html")
    public String updateAct(HttpServletRequest request, RegisterCommand cmd) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUserName(cmd.getName());
        newUser.setAge(cmd.getAge());
        newUser.setBGender(cmd.getGender());
        newUser = accountService.modifyUser(newUser);
        if (newUser != null) {
            request.getSession().setAttribute("user", newUser);
            return "redirect: account.html";
        } else {
            request.setAttribute("errmsg", "数据格式有误，请重试");
            return "account/updateinfo";
        }
    }

    @RequestMapping(value = "export.html")
    public String export(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "export" + "\"");
            response.setContentType("application/octet-stream;charset=UTF-8");
            ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
            oos.writeObject(user);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            return "redirect: index.html";
        }
        return "";
    }

    @RequestMapping(value = "import.html")
    public String _import(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        try {
            if (!file.isEmpty()) {
                InputStream is = file.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Object o = ois.readObject();
                ois.close();
                if (!(o instanceof  User)) {
                    throw new Exception();
                }
                User u = (User) o;
                for (Tag t:
                        u.getTags()) {
                    if (!user.getTags().contains(t)) {
                        t.setContents(new HashSet<Content>());
                        tagService.addTag(t);
                    }
                }
                for (Content c:
                     u.getContents()) {
                    if (!user.getContents().contains(c))
                        contentService.addContent(c);
                }
                request.getSession().setAttribute("user", accountService.queryByEmail(user.getEmail()));
//                System.out.println("000000000");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return "redirect: index.html";
        }
        return "redirect: index.html";
    }

}
