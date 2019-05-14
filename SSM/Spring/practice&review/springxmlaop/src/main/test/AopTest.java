import online.yuluo.dao.IUserDao;
import online.yuluo.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopTest {

//    @Resource(name = "userDao")
//    private UserDaoImpl userDao;

    @Test
    public void run() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDao userDao = (IUserDao) ac.getBean("userDao");
        userDao.saveUser();
        userDao.updateUser();
    }

}
