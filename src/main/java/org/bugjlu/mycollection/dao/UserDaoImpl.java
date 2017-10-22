package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        user.setPassword("");
        return user;
    }

    @Override
    public User update(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
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
        user.setPassword(null);
        return user;
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
        if (userList != null)
        {
            for(Iterator<User> it = userList.iterator(); it.hasNext(); )
            {
                User tmpUser = (User) it.next();
                tmpUser.setPassword(null);               //返回之前把密码置空
            }
        }
        return userList;
    }

    @Override
    public List FuzzyQueryByEmail(String email) {
        Session session = null;
        List<User> userList = new ArrayList();
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
        for (User user : userList)
        {
            user.setPassword(null);
        }
        return userList;
    }

    @Override
    public List FuzzyQueryByName(String name) {
        Session session = null;
        List<User> userList = new ArrayList();
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
    public User LoginCheck(String email, String password) {
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
            System.out.println("UserDaoImpl:save失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        if (user != null & user.getPassword().equals(password))
        {
            return user;
        }
        return null;
    }
}
