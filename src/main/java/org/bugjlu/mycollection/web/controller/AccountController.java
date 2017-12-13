package org.bugjlu.mycollection.web.controller;


import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.web.vo.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value="/")
public class AccountController {

    @Autowired
    AccountService accountService;

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
    public String updateInfo(HttpServletRequest request, HttpServletResponse response) {
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

}
