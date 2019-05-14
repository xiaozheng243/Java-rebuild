import online.yuluo.dao.IUserDao;
import online.yuluo.dao.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CommonAgencyDemo {

    @Test
    public void run() {
        IUserDao userDao = new UserDaoImpl();

        IUserDao proxyUser = this.getProxy(userDao);
        proxyUser.saveUser();
    }

    /**
     * 动态代理
     *
     * @param
     * @return
     */
    public <T> T getProxy(T t) {
        T dao1 = (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (("saveUser").equals(method.getName())) {
                    // dosomething
                }
                System.out.println(method.getName() + " proxy before");
                return method.invoke(t, args);
            }
        });
        return dao1;
    }
}
