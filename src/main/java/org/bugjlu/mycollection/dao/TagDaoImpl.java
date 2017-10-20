package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Set;

public class TagDaoImpl implements TagDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(Tag tag) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(tag);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("TagDaoImpl:update失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void save(Tag tag) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(tag);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("TagDaoImpl:save失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Tag tag) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(tag);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("TagDaoImpl:delete失败");
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteContent(int tagId, int contentId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Tag tag = session.get(Tag.class, tagId);
            Set allContent = tag.getContents();
            for (Iterator<Content> it = allContent.iterator(); it.hasNext() ;)
            {
                Content content = (Content) it.next();
                if (content.getId() == contentId)
                    allContent.remove(content);
            }
            tag.setContents(allContent);
            session.save(tag);
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
