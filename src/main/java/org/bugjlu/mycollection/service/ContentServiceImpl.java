package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.web.vo.ContentVo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            content.setUrl("baidu.com");
            content.setUserName("wang");
            List<Tag> tags = new ArrayList<Tag>();
            Tag tag = new Tag();
            tag.setTagName("lalala");
            Tag tag2 = new Tag();
            tag2.setTagName("hahaha");
            tags.add(tag);tags.add(tag2);
            content.setTags(tags);
            contents.add(content);
        }
        return contents;
    }

    public List<ContentVo> getLatestContentFrom(User requester, User respondent, Date time) {
        return null;
    }
}
