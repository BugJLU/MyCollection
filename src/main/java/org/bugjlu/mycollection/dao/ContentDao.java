package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContentDao {
    public Content save(Content tmpContent);
    public Content update(Content content);
    public Boolean delete(Integer id);
//    public List<Content> queryByEmail(String email);
    public Content addTag(Integer contentId, Integer tagId);
    public Content deleteTag(Integer contentId,Integer tagId);
    public List<Content> QueryContentsByEmail(String requester,String respondent);
}
