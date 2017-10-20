package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.ContentService;
import org.bugjlu.mycollection.web.vo.ContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "index.html")
    ModelAndView index(HttpServletRequest request){
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("title", "欢迎");
            return new ModelAndView("index/visitor");
        }
        request.setAttribute("title", "我的");
        return new ModelAndView("redirect: my.html");

    }

    @RequestMapping(value = "my.html")
    String my(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "我的");
        List<ContentVo> contents = contentService.getContentFrom(user, user);
        System.out.println(contents.size());
        request.setAttribute("contents", contents);
        return "index/my";
    }

    @RequestMapping(value = "follow.html")
    String follow(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "关注");
        return "index/follow";
    }

//    @RequestMapping(value = "hot.html")
//    String hot(HttpServletRequest request) {
//        request.setAttribute("title", "热门");
//        return "index/hot";
//    }
}
