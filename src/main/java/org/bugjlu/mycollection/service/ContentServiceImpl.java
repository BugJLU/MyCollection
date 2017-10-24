package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.ContentDao;
import org.bugjlu.mycollection.dao.TagDao;
import org.bugjlu.mycollection.dao.UserDao;
import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.web.vo.ContentVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentServiceImpl implements ContentService {

    @Autowired
    UserDao userDao;

    @Autowired
    ContentDao contentDao;


    public Content addContent(Content content) {
        return contentDao.save(content);
    }

    public int removeContent(Integer contentId) {
        Boolean success = contentDao.delete(contentId);
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Content> QueryContentsByEmail(String email) {
        return contentDao.QueryContentsByEmail(email, email);
    }

    @Override
    public List<Content> getContentFrom(String requester, String respondent) {
        List<Content> list = contentDao.QueryContentsByEmail(requester, respondent);
        Collections.sort(list);
        return list;
    }

    @Override
    public List<Content> getContentFrom(String requester, List<String> respondents) {
        Set<Content> set = new HashSet<Content>();
        List<Content> list = new ArrayList<Content>();
        for (String respondent : respondents)
        {
            set.addAll(contentDao.QueryContentsByEmail(requester, respondent));
        }
        list.addAll(set);
        Collections.sort(list);
        return list;
    }
}
