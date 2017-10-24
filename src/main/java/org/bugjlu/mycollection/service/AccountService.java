package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

@Service
public interface AccountService {

    // Return null means no such user or password is wrong.
    User login(String email, String password);

    // Return null means user already exists or format illegal.
    User register(User user);

    User modifyUser(User user);

    List<User> searchUser(String key);

    User queryByEmail(String email);

    User follow(String followerEmail,String followeeEmail);

    User unfollow(String followerEmail, String followeeEmail);
}
