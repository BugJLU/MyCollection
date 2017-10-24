package org.bugjlu.mycollection.dao;

import org.bugjlu.mycollection.po.Content;
import org.bugjlu.mycollection.po.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TagDaoImpl implements TagDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Tag update(Tag tag) {
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
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return tag;
    }

    @Override
    public Tag save(Tag tag) {
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
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return tag;
    }

    @Override
    public Boolean delete(Integer tagId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "delete from Tag tag where tag.id = :tagId";
            int result = session.createQuery(hql).setParameter("tagId", tagId).executeUpdate();
//            session.delete(tag);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            session.getTransaction().rollback();
            System.out.println("TagDaoImpl:delete失败");
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public List QueryTagsByEmail(String email) {
        Session session = null;
        List tagsList = new ArrayList();
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "from Tag tag where tag.user.email = :email";
            tagsList = session.createQuery(hql).setParameter("email", email).list();
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
        return tagsList;
    }

    @Override
    public Tag QueryById(Integer tagId) {
        Session session = null;
        Tag tag = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            tag = session.get(Tag.class, tagId);
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
        return tag;
    }


    @Override
    public Tag addContent(Integer tagId, Integer contentId) {
        Session session = null;
        Tag tag = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Content content = session.get(Content.class, contentId);
            tag = session.get(Tag.class, tagId);
            Set contents = tag.getContents();
            contents.add(content);
            tag.setContents(contents);
            session.save(tag);
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
        return tag;
    }

    @Override
    public Tag deleteContent(Integer tagId, Integer contentId) {
        Session session = null;
        Tag tag = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            tag = session.get(Tag.class, tagId);
            Set contents = tag.getContents();

            for (Iterator it = contents.iterator(); it.hasNext();)
            {
                Content tmpContent = (Content) it.next();
                if (tmpContent.getId() == contentId)
                    it.remove();
            }
            tag.setContents(contents);
            session.save(tag);
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
        return tag;
    }

}
