package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.User;

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
}
