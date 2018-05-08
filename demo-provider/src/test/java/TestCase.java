import com.wonder.dao.UserDao;
import com.wonder.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestCase {

    ClassPathXmlApplicationContext cx;
    SqlSessionFactory factory;

    @Before
    public void init(){
        cx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        factory = cx.getBean("sqlSessionFactory",SqlSessionFactory.class);
    }
    @Test
    public void test01(){
        System.out.println(factory);
        SqlSession session = factory.openSession();
        System.out.println(session);
        session.close();
    }

    @Test
    public void test02(){
        UserDao userDao = cx.getBean("userDao",UserDao.class);
//        List<Map> list = userDao.findAllUser();
//        for(Map map : list){
//            System.out.println(map);
//        }
    }
}
