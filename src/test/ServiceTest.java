import org.bugjlu.mycollection.po.User;
import org.bugjlu.mycollection.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    FollowService followService;

    @Test
    public void t1() {
        User user =  followService.follow("11@qq.com", "123@qq.com");

    }
}
