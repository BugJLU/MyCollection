package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.ContentService;
import org.bugjlu.mycollection.service.FollowService;
import org.bugjlu.mycollection.web.vo.AddContentCommand;
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
    @Autowired
    FollowService followService;

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
        request.setAttribute("contents", contents);
        return "index/my";
    }

    @RequestMapping(value = "follow.html")
    String follow(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "关注");
        List<User> followees = followService.getAllFollowee(user.getEmail());
        List<ContentVo> contents = contentService.getContentFrom(user, followees);
        request.setAttribute("contents", contents);
        return "index/follow";
    }

    @RequestMapping(value = "addcontent.html")
    String addContent(HttpServletRequest request, AddContentCommand addcmd) {
        //TODO:
        Content content = new Content();
        content.setUrl(addcmd.getUrl());
        content.setPermission(addcmd.getPms());
        String[] tagNames = addcmd.getTags().split(",");
        for (int i = 0; i < tagNames.length; i++) {
            tagNames[i] = tagNames[i].trim();

        }
//        contentService.addContent();
        return null;
    }

//    @RequestMapping(value = "hot.html")
//    String hot(HttpServletRequest request) {
//        request.setAttribute("title", "热门");
//        return "index/hot";
//    }
}
