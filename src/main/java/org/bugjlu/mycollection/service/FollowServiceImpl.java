package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.UserDao;
import org.bugjlu.mycollection.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FollowServiceImpl implements FollowService {

    @Autowired
    UserDao userDao;

    public User follow(String followerEmail, String followeeEmail) {
//        User follower = userDao.QueryByEmail(followerEmail);
//        User followee = userDao.QueryByEmail(followeeEmail);
//        if (follower != null && followee != null)
//        {
        return userDao.addFollowee(followerEmail, followeeEmail);

    }

    public User unfollow(String followerEmail, String followeeEmail) {
//        User follower = userDao.QueryByEmail(followerEmail);
//        User followee = userDao.QueryByEmail(followeeEmail);
//        if (follower != null && followee != null)
//        {
        return userDao.removeFollowee(followerEmail, followeeEmail);

    }

    public List<User> getAllFollowee(String email) {
//        if (user != null)
//        {
        List<User> list = new ArrayList<User>();
        User user = userDao.QueryByEmail(email);
        if (user != null)
        {
            list.addAll(user.getFollowee());
        }
        Collections.sort(list);
        return list;
    }

}
