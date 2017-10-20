import org.bugjlu.mycollection.dao.ContentDaoImpl;
import org.bugjlu.mycollection.dao.TagDaoImpl;
import org.bugjlu.mycollection.dao.UserDaoImpl;
import org.bugjlu.mycollection.po.Tag;
import org.bugjlu.mycollection.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

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
        testUser.setContent(null);
        testUser.setEmail("1578644088@qq.com");
        testUser.setFolloweeEmail(null);
        testUser.setTag(null);
        testUser.setUserName("yujiayu");
        userDao.save(testUser);
        userDao.LoginCheck("1578644088@qq.com","123456");
        User tmpUser = userDao.QueryByEmail("1578644088@qq.com");
        System.out.println(tmpUser.getUserName());
        testUser.setUserName("leon");
        List userList = userDao.QueryByName("leon");
        for (Iterator it = userList.iterator(); it.hasNext(); )
        {
            System.out.println(((User)it.next()).getUserName());
        }
    }

    @Test
    public void TagTest()
    {
        Tag testTag = new Tag();
        testTag.setContent(null);
        testTag.setEmail("1578644088@qq.com");
        testTag.setTagName("标签1");
        tagDao.save(testTag);
    }

    @Test
    public void ContentTest()
    {

    }

}
