package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ContentService {
    void addContent(String email, Content content);
    void removeContent(Integer contentId);
    List<Content> getContentFrom(User requester, User respondent);
    List<Content> getLatestContentFrom(User requester, User respondent, Date time);
}
