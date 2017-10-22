package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "searchuser.html")
    public String searchUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "添加关注");
        //todo:
        String key = request.getParameter("skey");
        List<User> users = accountService.searchUser(key);
        request.setAttribute("result", users);
        return "account/searchuser";
    }

    @RequestMapping(value = "followuser.html")
    public String followUser(HttpServletRequest request)
    {
        String email = null;
        try {
            email = URLDecoder.decode(request.getParameter("email"),"UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        followService.follow(user.getEmail(),email);
        return "account" //重定向到查看资料界面
    }

}
