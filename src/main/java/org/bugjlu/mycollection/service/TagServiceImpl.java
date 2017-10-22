package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.TagDao;
import org.bugjlu.mycollection.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;

public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;

    public Tag addTag(Tag tag) {
        tagDao.save(tag);
        return ???
    }

    public void removeTag(Integer tagid) {

    }

    @Override
    public Tag modifyTag(Tag newTag) {
        return null;
    }

//    public Tag modifyTag(Integer tagid, Tag newTag) {
//
//    }

    public void addContentToTag(Integer contentId, Integer tagId) {

    }

    public void removeContentFromTag(Integer contentId, Integer tagId) {

    }
}
