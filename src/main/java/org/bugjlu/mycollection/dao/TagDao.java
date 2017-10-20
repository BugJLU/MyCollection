package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao {
    public void update(Tag tag);
    public void save(Tag tag);
    public void delete(Tag tag);
    public void deleteContent(int tagId, int contentId);
}
