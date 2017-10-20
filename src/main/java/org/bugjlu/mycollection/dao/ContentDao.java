package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ContentDao {
    public void insert(Content tmpContent);
    public void delete(int id);
    public List<Content> queryByEmail(String email);
    public void deleteTag(int contentId, int tagId);
}
