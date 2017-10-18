package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.web.vo.RegisterCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class RegisterController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "register.html")
    public String register(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "注册");
        return "register";
    }

    @RequestMapping(value = "regact.html")
    public ModelAndView regact(HttpServletRequest request, RegisterCommand regCmd) {

        request.setAttribute("title", "注册");
        if (regCmd.getEmail() == null) {
            return new ModelAndView("redirect: register.html");
        }

        User reg = new User();
        // TODO: Assign properties into reg.

        if ((reg = accountService.register(reg)) == null) {
            ModelAndView mav = new ModelAndView("register");
            mav.addObject("errmsg", "用户ID已存在！");
            return mav;
        }

        return new ModelAndView("redirect: login.html");
    }

}