package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface FollowService {
    User follow(String followerEmail, String followeeEmail);
    User unfollow(String followerEmail, String followeeEmail);
    List<User> getAllFollowee(String email);
}
