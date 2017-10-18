package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
    void follow(String followerEmail, String followeeEmail);
    void unfollow(String followerEmail, String followeeEmail);
    List<User> getAllFollowee(String email);
}
