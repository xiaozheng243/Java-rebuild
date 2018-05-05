package online.suiyu;

import online.suiyu.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        //插入
//        String sql = "insert into stu values(?,?)";
//        jdbcTemplate.update(sql, 5, "Linda");


        //查询第一个满足条件的内容
//        String sql = "select * from stu where id=?";
//        User user = jdbcTemplate.queryForObject(sql, new BeanMapper(), 2);
//        System.out.println(user);

        String sql = "select * from stu where name like ?";
        List<User> list = jdbcTemplate.query(sql, new BeanMapper(),"%s%");
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("操作完成！");

    }
}

class BeanMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        return user;
    }
}