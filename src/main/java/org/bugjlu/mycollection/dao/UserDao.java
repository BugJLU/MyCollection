package org.bugjlu.mycollection.dao;


import org.bugjlu.mycollection.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {
    public User save(User user);
    public User update(User user);
    public User QueryByEmail(String email);
    public List<User> QueryByName(String name);
    public List<User> FuzzyQueryByEmail(String email);
    public List<User> FuzzyQueryByName(String name);
    public Boolean LoginCheck(String email, String password);
    public User addFollowee(String followerEmail, String followeeEmail);
    public User removeFollowee(String followerEmail, String followeeEmail);
}
