package org.bugjlu.mycollection.dao;


import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {
    public void save(User user);
    public void update(User user);
    public User QueryByEmail(String email);
    public List QueryByName(String name);
    public User LoginCheck(String email, String password);
}
