package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;


import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContentDaoImpl implements ContentDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Content tmpContent) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(tmpContent);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:insert失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Content content = session.get(Content.class, id);
            session.delete(content);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:delete失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Content> queryByEmail(String email) {
        List contentList = new ArrayList();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Content content where content.email=:email").setParameter("email",email);
            session.getTransaction().commit();
            contentList = q.list();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:queryByEmail失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return contentList;
    }

    @Override
    public void deleteTag(int contentId, int tagId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Content content = session.get(Content.class, contentId);
            Set allTag = content.getTags();
            for (Iterator<Tag> it = allTag.iterator(); it.hasNext() ;)
            {
                Tag tag = (Tag) it.next();
                if (tag.getId() == tagId)
                    allTag.remove(tag);
            }
            content.setTags(allTag);
            session.save(content);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:queryByEmail失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
