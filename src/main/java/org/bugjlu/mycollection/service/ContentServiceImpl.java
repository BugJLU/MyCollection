package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.web.vo.ContentVo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentServiceImpl implements ContentService {
    public void addContent(String email, Content content) {

    }

    public void removeContent(Integer contentId) {

    }

    public List<ContentVo> getContentFrom(User requester, User respondent) {
        // TODO: rewrite
        ArrayList<ContentVo> contents = new ArrayList<ContentVo>();
        for (int i = 0; i < 10; i++) {
            ContentVo content = new ContentVo();
            content.setId(1);
            content.setDate(new Timestamp(new Date().getTime()));
            content.setUrl("http://tech.sina.com.cn/roll/2017-10-20/doc-ifymzksi0528605.shtml");
            content.setUserName("wang");
            List<Tag> tags = new ArrayList<Tag>();
            for (int j = 0; j < 5; j++) {
                Tag tag = new Tag();
                tag.setTagName("hehehe");
                tags.add(tag);
            }
            content.setTags(tags);
            contents.add(content);
        }
        return contents;
    }

    @Override
    public List<ContentVo> getContentFrom(User requester, List<User> respondents) {
        return getContentFrom(requester, requester);
    }

    public List<ContentVo> getLatestContentFrom(User requester, User respondent, Date time) {
        return null;
    }

    @Override
    public List<ContentVo> getLatestContentFrom(User requester, List<User> respondents, Date time) {
        return null;
    }

}
