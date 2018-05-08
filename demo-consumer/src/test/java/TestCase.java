import com.wonder.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/spring-mvc.xml"})
public class TestCase {

    @Resource
    private UserService userService;
    @Test
    public void test(){
        List<Map> list = userService.findAllUser();
        for(Map map : list){
            System.out.println(map);
        }
    }

}
