package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.web.vo.ContentVo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ContentService {
    void addContent(String email, Content content);
    void removeContent(Integer contentId);
    List<ContentVo> getContentFrom(User requester, User respondent);
    List<ContentVo> getContentFrom(User requester, List<User> respondents);
    List<ContentVo> getLatestContentFrom(User requester, User respondent, Date time);
    List<ContentVo> getLatestContentFrom(User requester, List<User> respondents, Date time);
}
