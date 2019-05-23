package online.suiyu.dao.impl;

import online.suiyu.dao.ClassifyDao;
import online.suiyu.domain.Astate;
import online.suiyu.domain.Classify;
import online.suiyu.domain.PostDemo;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassifyDaoImpl implements ClassifyDao {
    private QueryRunner runner = new QueryRunner();
//    private DataSourceUtils dataSourceUtils = new DataSourceUtils();

    @Override
    public List<Classify> getAllClassify() {
        String sql = "select * from classify";
        List<Classify> list = new ArrayList<>();
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Classify>(Classify.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addClassify(Classify classify) {
        String sql = "insert into classify(cname) values(?)";
        int count = 0;
        try {
            count = runner.execute(DataSourceUtils.getConnection(), sql, classify.getcName());
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public boolean deleteClassify(Classify classify) {
        String sql0 = "select * from post where classify=?";
        int count = 0;
        List<PostDemo> list = null;
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql0, new BeanListHandler<PostDemo>(PostDemo.class), classify.getcId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            String sql = "delete from classify where cid=?";
            try {
                count = runner.update(DataSourceUtils.getConnection(), sql, classify.getcId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count == 1;
    }

    @Override
    public boolean updateClassify(Classify classify) {
        String sql = "update classify set cname=? where cid=?";
        int count = 0;
        try {
            count = runner.update(DataSourceUtils.getConnection(), sql, classify.getcName(), classify.getcId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }
}
