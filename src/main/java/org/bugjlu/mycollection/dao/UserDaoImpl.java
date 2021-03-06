package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;

public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:save失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if (user != null)
            user.setPassword(null);
        return user;
    }

    @Override
    public User update(User user) {
        Session session = null;
        User newUser = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            newUser = session.get(User.class, user.getEmail());
            newUser.setUserName(user.getUserName());
//            if (user.getPassword() == null)
//            {
//                user.setPassword(session.get(User.class, user.getEmail()).getPassword());
//            }
            newUser.setGender(user.getGender());
            newUser.setAge(user.getAge());
            session.update(newUser);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:update失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if (newUser != null)
        {
            newUser.setPassword(null);
        }
        return newUser;
    }

    @Override
    public User QueryByEmail(String email) {
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = session.get(User.class, email);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:QueryByEmail失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if (user != null)
        {
            user.setPassword(null);
        }
        return user;
    }

    @Override
    public List QueryByName(String name) {
        Session session = null;
        List userList = new ArrayList();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from User user where user.userName=:username")
                    .setParameter("username", name);
            userList = q.list();
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:QueryByName失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if ( userList != null )
        {
            for (Object user : userList)
            {
                ((User)user).setPassword(null);
            }
        }
        return userList;
    }

    @Override
    public List<User> FuzzyQueryByEmail(String email) {
        Session session = null;
        List<User> userList = new ArrayList<User>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from User user where user.email like :email")
                    .setParameter("email", "%" + email + "%");
            userList = q.list();
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:QueryByEmail失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if (userList != null)
        {
            for (Object user : userList)
            {
                ((User)user).setPassword(null);
            }
        }
        return userList;
    }

    @Override
    public List<User> FuzzyQueryByName(String name) {
        Session session = null;
        List<User> userList = new ArrayList<User>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from User user where user.userName like :username")
                    .setParameter("username", "%" + name + "%");
            userList = q.list();
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:QueryByEmail失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        for (User user : userList)
        {
            user.setPassword(null);
        }
        return userList;
    }

    @Override
    public Boolean LoginCheck(String email, String password) {
        Session session = null;
        List<User> user = new ArrayList<User>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "from User user where email=:email and password=:password";
            Query q = session.createQuery(hql).setParameter("email",email).setParameter("password",password);
            user = q.list();
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:save失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return user.size() > 0;
    }

    @Override
    public User addFollowee(String followerEmail, String followeeEmail) {
        Session session = null;
        User follower = null;
        //User followee = QueryByEmail(followeeEmail);
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            follower = session.get(User.class, followerEmail);
            User followee = session.load(User.class, followeeEmail);
            Set allFollowee = follower.getFollowee();
            allFollowee.add(followee);
            follower.setFollowee(allFollowee);
            if (follower.getPassword() == null)
            {
                follower.setPassword(session.get(User.class, follower.getEmail()).getPassword());
            }
            session.update(follower);
//            if (follower.getPassword() == null)
//            {
//                follower.setPassword(session.get(User.class, follower.getEmail()).getPassword());
//            }
//            follower.getFollowee().add(followee);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:update失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        follower.setPassword(null);
        return follower;
    }

    @Override
    public User removeFollowee(String followerEmail, String followeeEmail) {
        Session session = null;
        User follower = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            follower = session.get(User.class, followerEmail);
            Set allFollowee = follower.getFollowee();
            User followee = new User();
            followee.setEmail(followeeEmail);
            allFollowee.remove(followee);
//            for (Object user : allFollowee)
//            {
//                if ( ((User)user).getEmail().eq == followeeEmail )
//                {
//                    allFollowee.remove(user);
//                }
//            }
            follower.setFollowee(allFollowee);
            session.update(follower);
//            if (follower.getPassword() == null)
//            {
//                follower.setPassword(session.get(User.class, follower.getEmail()).getPassword());
//            }
//            follower.getFollowee().add(followee);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("UserDaoImpl:update失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        follower.setPassword(null);
        return follower;
    }
}
