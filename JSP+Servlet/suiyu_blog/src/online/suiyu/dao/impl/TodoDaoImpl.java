package online.suiyu.dao.impl;

import online.suiyu.dao.TodoDao;
import online.suiyu.domain.Todo;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    @Override
    public boolean updateTodo(String todo) {
        String sql = "update todo set content=?";
        DataSourceUtils dataSourceUtils = new DataSourceUtils();
        QueryRunner runner = new QueryRunner();
        int count = 0;
        try {
            count = runner.update(dataSourceUtils.getConnection(), sql, todo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public String getTodo() {
        String sql = "select * from todo";
        Connection connection = DataSourceUtils.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet set = null;
        String result = new String();
        try {
            set = statement.executeQuery();
            while (set.next()) {
                result = set.getString("content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("result:" + result);
        return result;
    }
}
