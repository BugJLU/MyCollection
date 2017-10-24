package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    Tag addTag(Tag tag);
    int removeTag(Integer tagid);
    Tag modifyTag(Tag newTag);
    Tag addContentToTag(Integer contentId, Integer tagId);
    Tag removeContentFromTag(Integer contentId, Integer tagId);
    List<Tag> getTagsByEmail(String email);
}
