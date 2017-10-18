package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    // Return null means no such user or password is wrong.
    User login(String email, String password);

    // Return null means user already exists or format illegal.
    User register(User user);

    // Return null means user can't be modified in that way.
    User modifyAccount(String email, User newInfo);

}
