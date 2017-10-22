package org.bugjlu.mycollection.web.controller;


import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/")
public class AccountController {
    @RequestMapping(value="account.html")
    public String account(HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        return "account/account";
    }

    @RequestMapping(value="updateinfo.html")
    public String updateInfo(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        return "account/updateinfo";
    }


}
