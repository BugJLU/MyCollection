package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.UserDao;
import org.bugjlu.mycollection.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FollowServiceImpl implements FollowService {

    @Autowired
    UserDao userDao;

    public void follow(String followerEmail, String followeeEmail) {
        User user = userDao.QueryByEmail(followerEmail);
        user.addFollowee(User user, )
    }

    public void unfollow(String followerEmail, String followeeEmail) {

    }

    public List<User> getAllFollowee(String email) {
        return null;
    }

}
