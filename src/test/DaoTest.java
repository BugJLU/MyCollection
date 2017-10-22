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
        User testUser = new User();
        testUser.setPassword("123456");
        testUser.setAge(18);
        testUser.setBGender(true);
        testUser.setContents(null);
        testUser.setEmail("1578644088@qq.com");
        testUser.setFolloweeEmail(null);
        testUser.setTags(null);
        testUser.setUserName("yujiayu");
        userDao.save(testUser);
        userDao.LoginCheck("1578644088@qq.com","123456");
        User tmpUser = userDao.QueryByEmail("1578644088@qq.com");
        System.out.println(tmpUser.getUserName());
        testUser.setUserName("leon");
        userDao.update(testUser);
        List userList = userDao.QueryByName("yujiayu");
        for (Iterator it = userList.iterator(); it.hasNext(); )
        {
            System.out.println(((User)it.next()).getUserName());
        }
    }

    @Test
    public void TagTest()
    {
        Set<Tag> tags = new HashSet<Tag>();
        User testUser = userDao.QueryByEmail("1578644088@qq.com");
        Assert.assertNotNull(testUser);
        for ( int i = 0; i < 10; i++ ) {
            Tag testTag = new Tag();
            testTag.setContents(null);
            testTag.setUser(testUser);
            testTag.setTagName("标签"+i);
            tags.add(testTag);
            tagDao.save(testTag);
        }

        for (Tag tag:
             testUser.getTags()) {
            System.out.println(tag.getTagName());
        }
    }

    @Test
    public void ContentTest()
    {

    }

}
