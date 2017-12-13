package org.bugjlu.mycollection.web.controller;


import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.service.ContentService;
import org.bugjlu.mycollection.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/")
public class ContentController {
    @Autowired
    ContentService contentService;

    @Autowired
    TagService tagService;

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/contentdelete.html")
    public String deleteContent(HttpServletRequest request)
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
        String id = request.getParameter("id");
        int result = contentService.removeContent(Integer.parseInt(id));
        request.getSession().setAttribute("user", accountService.queryByEmail(user.getEmail()));
        return "redirect: my.html";

    }

}
