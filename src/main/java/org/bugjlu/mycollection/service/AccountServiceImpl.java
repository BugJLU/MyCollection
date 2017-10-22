package org.bugjlu.mycollection.service;

import org.bugjlu.mycollection.dao.UserDaoImpl;
import org.bugjlu.mycollection.po.User;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    public User login(String email, String password) {
        // TODO: rewrite
//        User user = new User();
//        user.setUserName("王二狗");
//        user.setEmail("www");
//        return user;
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.LoginCheck(email,password);
    }

    public User register(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        return  userDao.save(user);
    }

    @Override
    public List searchUser(String key) {
        UserDaoImpl userDao = new UserDaoImpl();
        List nameList = userDao.FuzzyQueryByName(key);
        List emailList = userDao.FuzzyQueryByEmail(key);
        return emailList.addAll(nameList)? emailList : null;
    }

    @Override
    public User modifyUser(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.update(user);
    }
}
