package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao {
    public Tag update(Tag tag);
    public Tag save(Tag tag);
    public Boolean delete(Integer tagId);
    public Tag addContent(Integer tagId, Integer contentId);           //和ContentDao 的 addTag其实效果一样
    public Tag deleteContent(Integer tagId,Integer contentId);         //和ContentDao 的 deleteTag其实效果一样
    public Tag QueryById(Integer tagId);
    public List QueryTagsByEmail(String email);
}
