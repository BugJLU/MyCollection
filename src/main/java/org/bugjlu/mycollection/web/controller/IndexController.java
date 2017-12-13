package org.bugjlu.mycollection.web.controller;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.AccountService;
import org.bugjlu.mycollection.service.ContentService;
import org.bugjlu.mycollection.service.FollowService;
import org.bugjlu.mycollection.service.TagService;
import org.bugjlu.mycollection.web.vo.AddContentCommand;
import org.bugjlu.mycollection.web.vo.ContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    ContentService contentService;
    @Autowired
    FollowService followService;
    @Autowired
    TagService tagService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "index.html")
    ModelAndView index(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("title", "欢迎");
            return new ModelAndView("index/visitor");
        }
        request.setAttribute("title", "我的");
        return new ModelAndView("redirect: my.html");
    }

    @RequestMapping(value = "my.html")
    String my(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "我的");
        List<Content> contents = contentService.getContentFrom(user.getEmail(), user.getEmail());
        List<ContentVo> results = new ArrayList<ContentVo>();
        for (Content c :
                contents) {
            results.add(new ContentVo(c));
        }
        request.setAttribute("contents", results);
        return "index/my";
    }

    @RequestMapping(value = "tag.html")
    String tag(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        String idp = request.getParameter("id");
        Integer tagid = null;
        try {
            tagid = Integer.parseInt(idp);
        } catch (Exception e) {
            return "redirect: index.html";
        }
        Tag tag = null;
        for (Tag t :
                user.getTags()) {
            if(t.getId().equals(tagid)) {
                tag = t;
                break;
            }
        }
        if (tag == null) return "redirect: index.html";
        request.setAttribute("title", "标签 - "+tag.getTagName());
        request.setAttribute("subtitle", "标签"+tag.getTagName()+"下的内容：");
        List<ContentVo> results = new ArrayList<ContentVo>();
        for (Content c:
             tag.getContents()) {
            results.add(new ContentVo(c));
        }
        request.setAttribute("contents", results);
        return "index/my";
    }

    @RequestMapping(value = "follow.html")
    String follow(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        request.setAttribute("title", "关注");
        List<User> followees = followService.getAllFollowee(user.getEmail());
        if (followees.size() == 0) {
            request.setAttribute("contents", null);
            return "index/follow";
        }
        List<String> followeeEmails = new ArrayList<String>();
        for (User email : followees){
            followeeEmails.add(email.getEmail());
        }
        List<Content> contents = contentService.getContentFrom(user.getEmail(), followeeEmails);
        List<ContentVo> results = new ArrayList<ContentVo>();
        for (Content c :
                contents) {
            results.add(new ContentVo(c));
        }
        request.setAttribute("contents", results);
        return "index/follow";
    }


    //TODO: not checked.
    @RequestMapping(value = "addcontent.html")
    String addContent(HttpServletRequest request, AddContentCommand addcmd) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        Set<Tag> tagSet = user.getTags();
        TreeMap<String, Tag> map = new TreeMap<String, Tag>();
        for (Tag t :
                tagSet) {
            map.put(t.getTagName(), t);
        }
        Content content = new Content();
        content.setUser(user);
        content.setDate(new Date());
        content.setUrl(addcmd.getUrl());
        content.setPermission(addcmd.getPms());
        TreeSet<Tag> tags = new TreeSet<Tag>();
        String[] tagNames = addcmd.getTags().split(",");
        for (int i = 0; i < tagNames.length; i++) {
            tagNames[i] = tagNames[i].trim();
            if (map.containsKey(tagNames[i])) {
                tags.add(map.get(tagNames[i]));
            } else {
                Tag tag = new Tag();
                tag.setTagName(tagNames[i]);
                tag.setUser(user);
//                tagService.addTag(tag);
                tag = tagService.addTag(tag);
                tags.add(tag);
            }
        }
        content.setTags(tags);
        contentService.addContent(content);
//        contentService.addContent();
        request.getSession().setAttribute("user", accountService.queryByEmail(user.getEmail()));
//        user = accountService.
        return "redirect: my.html";
    }

    @RequestMapping(value = "delete_content.html")
    String deleteContent(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect: index.html";
        }
        String cid = request.getParameter("id");
        Integer contentId = null;
        try {
            contentId = Integer.parseInt(cid);
        } catch (Exception e) {
            return "redirect: index.html";
        }
        for (Content c:
             user.getContents()) {
            if (c.getId().equals(contentId)) {
                contentService.removeContent(contentId);
                break;
            }
        }
        return "redirect: index.html";
    }

//    @RequestMapping(value = "hot.html")
//    String hot(HttpServletRequest request) {
//        request.setAttribute("title", "热门");
//        return "index/hot";
//    }
}
