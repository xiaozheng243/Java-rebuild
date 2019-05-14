import online.yuluo.dao.IUserDao;
import online.yuluo.dao.UserDaoImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于cglib的代理
 */
public class CglibAgencyDemo {

    @Test
    public void test() {
        IUserDao dao = new UserDaoImpl();
        IUserDao newDao = this.getProxy(dao);
        newDao.saveUser();

    }

    public <T> T getProxy(T t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName() + " proxy before");
                return null;
            }
        });
        T t1 = (T) enhancer.create();
        return t1;
    }
}


