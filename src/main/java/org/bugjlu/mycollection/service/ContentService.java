package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.web.vo.ContentVo;
import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ContentService {
    Content addContent(Content content);
    int removeContent(Integer contentId);
    List<Content> QueryContentsByEmail(String email);
    List<Content> getContentFrom(String requester, String respondent);
    List<Content> getContentFrom(String requester, List<String> respondents);
//    List<ContentVo> getLatestContentFrom(User requester, User respondent, Date time);
//    List<ContentVo> getLatestContentFrom(User requester, List<User> respondents, Date time);
}
