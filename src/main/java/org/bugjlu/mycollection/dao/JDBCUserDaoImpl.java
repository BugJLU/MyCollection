package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.User;

import java.util.List;

public class JDBCUserDaoImpl implements UserDao{
    @Override
    public void save(User user) {
        Class.forName("")
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User QueryByEmail(String email) {
        return null;
    }

    @Override
    public List QueryByName(String name) {
        return null;
    }

    @Override
    public User LoginCheck(String email, String password) {
        return null;
    }
}
