import org.bugjlu.mycollection.dao.ContentDaoImpl;
import org.bugjlu.mycollection.dao.TagDaoImpl;
import org.bugjlu.mycollection.dao.UserDaoImpl;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DaoTest extends AbstractTestNGSpringContextTests{
    @Autowired
    UserDaoImpl userDao;

    @Autowired
    ContentDaoImpl contentDao;

    @Autowired
    TagDaoImpl tagDao;

    @Test
    public void UserTest()
    {
//        User testUser = new User();
//        testUser.setPassword("12345678");
//        testUser.setAge(18);
//        testUser.setBGender(true);
//        testUser.setContents(null);
//        testUser.setEmail("123@qq.com");
//        Set followee = new HashSet();
//        followee.add(userDao.QueryByEmail("1578644088@qq.com"));
//        testUser.setFollowee(followee);
//        testUser.setTags(null);
//        testUser.setUserName("yujiayu");
//        userDao.save(testUser);



//        userDao.LoginCheck("1578644088@qq.com","123456");
//        User tmpUser = userDao.QueryByEmail("1578644088@qq.com");
//        System.out.println(tmpUser.getUserName());
//        testUser.setUserName("leon");
//        userDao.update(testUser);
//        List userList = userDao.QueryByName("yujiayu");
//        for (Iterator it = userList.iterator(); it.hasNext(); )
//        {
//            System.out.println(((User)it.next()).getUserName());
//        }


//        System.out.println(userDao.LoginCheck("11@qq.com", "123"));
//        System.out.println(userDao.LoginCheck("11@qq.com", "1234"));
//
//
//        User user0 = userDao.QueryByEmail("11@qq.com");
//        user0.setPassword("1234");
//        userDao.update(user0);
//
//
        User user1 = (User) userDao.QueryByName("leon").get(0);
        System.out.println(userDao.QueryByName("leon").size());
        User user2 = userDao.FuzzyQueryByName("yuj").get(0);
        userDao.addFollowee(user1.getEmail(),user2.getEmail());



    }

    @Test
    public void TagTest()
    {
//        Set<Tag> tags = new HashSet<Tag>();
//        User testUser = userDao.QueryByEmail("1578644088@qq.com");
//        Assert.assertNotNull(testUser);
//        for ( int i = 0; i < 10; i++ ) {
//            Tag testTag = new Tag();
//            testTag.setContents(null);
//            testTag.setUser(testUser);
//            testTag.setTagName("标签"+i);
//            tags.add(testTag);
//            tagDao.save(testTag);
//        }
//
//        for (Tag tag:
//             testUser.getTags()) {
//            System.out.println(tag.getTagName());
//        }

//        tagDao.addContent(7,53);
//
//        tagDao.delete(6);
//
//        tagDao.addContent(11, 53);
//
//        Tag tag = tagDao.QueryById(8);
//        System.out.println(tag.getTagName());
//
//        List<Tag> list = tagDao.QueryTagsByEmail("1578644088@qq.com");
//        for (Tag tag1 : list)
//        {
//            System.out.println(tag1.getId());
//        }
//
//        Tag tag2 = tagDao.QueryById(8);
//        tag2.setId(21);
//        tagDao.save(tag2);

//        Tag tag3 = tagDao.QueryById(8);
//        tag3.setTagName("标签88888");
//        tagDao.update(tag3);



    }

    @Test
    public void ContentTest()
    {
//        for (int i = 0; i < 10 ; i++)
//        {
//            Content testContent = new Content();
//            testContent.setDate(new Date());
//            testContent.setPermission(1);
//            Set tags  = new HashSet();
//            tags.add(tagDao.QueryById(6));
//            tags.add(tagDao.QueryById(7));
//            tags.add(tagDao.QueryById(8));
//            testContent.setTags(tags);
//            testContent.setUser(userDao.QueryByEmail("1578644088@qq.com"));
//            testContent.setUrl("www.baidu,com"+ i + i + i + i);
//            contentDao.save(testContent);
//        }

//        contentDao.delete(51);
//
//


//        contentDao.delete(52);
//        contentDao.deleteTag(53,7);
//        contentDao.addTag(53,9);
    }

}
