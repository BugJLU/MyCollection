package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.web.vo.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    AccountService accountService;

    @RequestMapping("login.html")
    public String login(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "登录");
        return "account/login";
    }

    @RequestMapping(value = "forgetaccount.html")
    public String forget(HttpServletRequest request) {
        request.setAttribute("title", "账号找回");
        return "account/forgetaccount";
    }

    @RequestMapping(value = "loginact.html")
    public ModelAndView loginact(HttpServletRequest request, LoginCommand loginCommand) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (loginCommand.getEmail() == null) {
            return new ModelAndView("redirect: login.html");
        }
        request.setAttribute("title", "登录");
        User user = accountService.login(loginCommand.getEmail(), loginCommand.getPassword());
        if (user == null) {
            return new ModelAndView("account/login", "errmsg", "用户名或密码错误！");
        }
        request.getSession().setAttribute("user", user);
        return new ModelAndView("redirect: index.html");
    }

    @RequestMapping(value = "logout.html")
    public String logout(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.getSession().removeAttribute("user");
        return "redirect: index.html";
    }

}
