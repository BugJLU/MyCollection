package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.User;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    public User login(String email, String password) {
        // TODO: rewrite
        User user = new User();
        user.setUserName("王二狗");
        user.setEmail("www");
        return user;
    }

    public User register(User user) {
        return null;
    }

    public User modifyAccount(String email, User newInfo) {
        return null;
    }

    @Override
    public List<User> searchUser(String key) {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setEmail("aaa@bbb.ccc");
            user.setUserName("AAABBBCCC");
            user.setGender("M");
            user.setAge(18);
            users.add(user);
        }
        return users;
    }
}
