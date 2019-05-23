package online.suiyu.dao.impl;

import online.suiyu.dao.SearchDao;
import online.suiyu.domain.PostDemo;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImpl implements SearchDao {
    @Override
    public ArrayList<PostDemo> getPostsBySearch(String searchValue) {
        String sql = "select aid,title,details,creation,classify.cname 'classify' from post,classify where post.classify=classify.cid and post.stateid=6001 and post.details like '%"+searchValue+"%'";
        List<PostDemo> list = null;
        try {
            list = new QueryRunner().query(DataSourceUtils.getConnection(), sql, new BeanListHandler<PostDemo>(PostDemo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<PostDemo>) list;
    }
}
