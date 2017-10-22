package org.bugjlu.mycollection.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/")
public class AccountController {
    @RequestMapping(value="account.html")
    public String account(HttpServletRequest request)
    {

    }

    @RequestMapping(value="updateinfo.html")
    public String account(HttpServletRequest request)


}
