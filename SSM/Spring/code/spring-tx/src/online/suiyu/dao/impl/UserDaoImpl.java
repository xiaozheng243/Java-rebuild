package online.suiyu.dao.impl;

import online.suiyu.dao.UserDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    @Override
    public void add(int id) {
        String sql = "update stu set name='Tom1' where id=?";
        this.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void reduce(int id) {
        String sql = "update stu set name='Jack1' where id=?";
        this.getJdbcTemplate().update(sql, id);
    }
}
