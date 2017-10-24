package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;


import org.hibernate.query.Query;

import java.util.*;

public class ContentDaoImpl implements ContentDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Content save(Content tmpContent) {
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
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return tmpContent;
    }

    @Override
    public Content update(Content content) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(content);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:update失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return content;
    }

    @Override
    public Boolean delete(Integer id) {
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
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

//    @Override
//    public List<Content> queryByEmail(String email) {
//        List contentList = new ArrayList();
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            Query q = session.createQuery("from Content content where content.user.=:email").setParameter("email",email);
//            session.getTransaction().commit();
//            contentList = q.list();
//        } catch (Exception e)
//        {
//            session.getTransaction().rollback();
//            System.out.println("ContentDaoIMpl:queryByEmail失败");
//            e.printStackTrace();
//        }finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return contentList;
//    }

    @Override
    public Content addTag(Integer contentId, Integer tagId) {
        Session session = null;
        Content content = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            content = session.get(Content.class, contentId);
            Tag tag = session.get(Tag.class, tagId);
            Set tags = content.getTags();
            tags.add(tag);
            content.setTags(tags);
            session.save(content);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:queryByEmail失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return content;
    }

    @Override
    public Content deleteTag(Integer contentId, Integer tagId) {
        Session session = null;
        Content content = null;
        Set<Tag> tags = new HashSet<Tag>();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            content = session.get(Content.class, contentId);
            tags = content.getTags();
            for(Iterator it = tags.iterator(); it.hasNext(); )
            {
                Tag tmpTag = (Tag) it.next();
                if (tmpTag.getId() == tagId)
                    it.remove();
            }
            content.setTags(tags);
            session.update(content);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("ContentDaoIMpl:deleteTag失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return content;
    }

    @Override
    public List<Content> QueryContentsByEmail(String requester,String respondent) {
        Session session = null;
        List<Content> contentsList = new ArrayList<Content>();
        int permission;
        if (requester.equals(respondent)){
            permission = 2;
        } else {
            permission = 1;
        }
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "from Content content where content.user.email = :email and content.permission < :permission";
            contentsList = session.createQuery(hql).setParameter("email", respondent).setParameter("permission",permission).list();
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("TagDaoImpl:save失败");
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return contentsList;
    }

}
