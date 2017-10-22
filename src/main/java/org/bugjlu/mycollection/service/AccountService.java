package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    // Return null means no such user or password is wrong.
    User login(String email, String password);

    // Return null means user already exists or format illegal.
    User register(User user);

    List searchUser(String key);

    User modifyUser(User user);

    List<User> searchUser(String key);

}
