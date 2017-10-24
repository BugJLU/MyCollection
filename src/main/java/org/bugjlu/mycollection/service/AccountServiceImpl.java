package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.UserDao;
import org.bugjlu.mycollection.dao.UserDaoImpl;
import org.bugjlu.mycollection.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class AccountServiceImpl implements AccountService {

    @Autowired
    UserDao userDao;

    public User login(String email, String password) {
        // TODO: rewrite
//        User user = new User();
//        user.setUserName("王二狗");
//        user.setEmail("www");
//        return user;
        Boolean success = userDao.LoginCheck(email,password);
        if (success) {
            return userDao.QueryByEmail(email);
        } else {
            return null;
        }
    }

    public User register(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> searchUser(String key) {
        Set<User> set = new HashSet<User>();
        List<User> list = new ArrayList<User>();
        set.addAll(userDao.FuzzyQueryByName(key));
        set.addAll(userDao.FuzzyQueryByEmail(key));
        list.addAll(set);
        Collections.sort(list);
        return list;
    }

    @Override
    public User queryByEmail(String email) {
        return userDao.QueryByEmail(email);
    }

    @Override
    public User modifyUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User follow(String followerEmail, String followeeEmail) {
        return userDao.addFollowee(followerEmail, followeeEmail);
//        User follower = userDao.QueryByEmail(followerEmail);
//        User followee = userDao.QueryByEmail(followeeEmail);
//        if (follower != null && followee != null)
//        {
//            userDao.addFollowee(follower, followee);
//        }
    }

    @Override
    public User unfollow(String followerEmail, String followeeEmail) {
        return userDao.removeFollowee(followerEmail,followeeEmail);
//        User follower = userDao.QueryByEmail(followerEmail);
//        User followee = userDao.QueryByEmail(followeeEmail);
//        if (follower != null && followee != null)
//        {
//            userDao.removeFollowee(follower, followee);
//        }
    }
}
