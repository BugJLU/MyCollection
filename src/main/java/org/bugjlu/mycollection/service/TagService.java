package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Tag;
import org.springframework.stereotype.Service;

@Service
public interface TagService {
    Tag addTag(Tag tag);
    void removeTag(Integer tagid);
    Tag modifyTag(Tag newTag);
    void addContentToTag(Integer contentId, Integer tagId);
    void removeContentFromTag(Integer contentId, Integer tagId);
}
