package org.bugjlu.mycollection.service;


import org.bugjlu.mycollection.dao.TagDao;
import org.bugjlu.mycollection.po.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;



    @Override
    public Tag addTag(Tag tag) {
        return tagDao.save(tag);                   //需不需要有查重检测
    }

    @Override
    public int removeTag(Integer tagid) {
        Boolean success = tagDao.delete(tagid);               //需不需要有存在性检测
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Tag addContentToTag(Integer contentId, Integer tagId) {
        return tagDao.addContent(tagId, contentId);               //存在性检测
    }

    @Override
    public Tag removeContentFromTag(Integer contentId, Integer tagId) {
        return tagDao.deleteContent(tagId, contentId);
    }

    @Override
    public Tag modifyTag(Tag newTag) {
        if (tagDao.QueryById(newTag.getId()) != null)
        {
            return tagDao.update(newTag);                  //需不需要对数据完整性进行检测
        }
        return null;

    }

    @Override
    public List<Tag> getTagsByEmail(String email) {
        List<Tag> list = new ArrayList<Tag>();
        list.addAll(tagDao.QueryTagsByEmail(email));
        return list;
    }
}
