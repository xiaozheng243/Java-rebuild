package online.suiyu.dao.impl;

import online.suiyu.dao.UserDao;
import online.suiyu.domain.User;
import online.suiyu.utils.DataSourceUtils;
import online.suiyu.utils.DateUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner = new QueryRunner();
//    private DataSourceUtils dataSourceUtils = new DataSourceUtils();

    @Override
    public User getUserByNameAndPwd(String username, String password) {
        String sql = "select * from user where username=? and upassword=?";
        User user = new User();
        try {
            user = runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private DateUtils dateUtils = new DateUtils();

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set username=?, upassword=?, email=?, usign=?, phone=?,github=?,photo=?,disc=? where id=?";
        Object[] params = {user.getUsername(), user.getUpassword(), user.getEmail(), user.getUsign(), user.getPhone(), user.getGithub(), user.getPhoto(), user.getDisc(), user.getId()};
        int count = 0;
        try {
            count = runner.update(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public User getUserProfile(User user) {
        String sql = "select * from user where username=?";
        try {
            user = runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<User>(User.class), user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
