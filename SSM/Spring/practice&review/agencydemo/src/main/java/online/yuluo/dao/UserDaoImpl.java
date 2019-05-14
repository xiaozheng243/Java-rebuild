package online.yuluo.dao;

public class UserDaoImpl implements IUserDao {

    @Override
    public void saveUser() {
        System.out.println("UserDaoImpl saveUser");
    }

    @Override
    public void updateUser() {
        System.out.println("UserDaoImpl updateUser");
    }
}
