package online.suiyu.dao.impl;

import online.suiyu.dao.PostDao;
import online.suiyu.domain.Classify;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {
    //    private DataSourceUtils dataSourceUtils = new DataSourceUtils();
    private QueryRunner runner = new QueryRunner();

    @Override
    public ArrayList<PostDemo> getPostsForPublish() {
        return (ArrayList<PostDemo>) getPosts(6001);
    }

    @Override
    public ArrayList<PostDemo> getPostsForDraft() {
        return (ArrayList<PostDemo>) getPosts(6002);
    }

    @Override
    public ArrayList<PostDemo> getPostsForRecycle() {
        return (ArrayList<PostDemo>) getPosts(6003);
    }

    @Override
    public List<PostDemo> getPosts(int astate) {
        String sql = "select aid,title,details,creation,classify.cname 'classify' from post,classify where post.classify=classify.cid and post.stateid=?";
        List<PostDemo> list = null;
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<PostDemo>(PostDemo.class), astate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updatePost(Post post) {
        String sql = "update post set title=?,details=?,classify=?,stateid=? where aid=?";
        Object[] params = {post.getTitle(), post.getDetails(), post.getClassify(), post.getStateid(), post.getAid()};
        int count = 0;
        try {
            count = runner.update(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    public boolean removePost(Post post) {
        String sql = "update post set stateid=6003 where aid=?";
        Object[] params = {post.getAid()};
        int count = 0;
        try {
            count = runner.update(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    public boolean changePost(Post post, int state) {
        String sql = "update post set stateid=? where aid=?";
        Object[] params = {state, post.getAid()};
        int count = 0;
        try {
            count = runner.update(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public PostDemo getPostForOne(int aid) {
        String sql = "select aid,title,details,creation,classify.cname 'classify' from post,classify where post.classify=classify.cid and aid=?";
        PostDemo postDemo = new PostDemo();
        try {
            postDemo = runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<PostDemo>(PostDemo.class), aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postDemo;
    }

    @Override
    public List<PostDemo> getPostForClassify(Classify classify) {
        String sql = "select * from post where classify=?";
        List<PostDemo> list = new ArrayList<>();
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<PostDemo>(PostDemo.class), classify.getcId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deletePost(Post post) {
        String sql = "delete from post where aid=?";
        int count = 0;
        try {
            count = runner.execute(DataSourceUtils.getConnection(), sql, post.getAid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    public boolean addPost(Post post) {
        String sql = "insert into post(title,details,classify,stateid) values(?,?,?,?)";
        Object[] params = {post.getTitle(), post.getDetails(), post.getClassify(), post.getStateid()};
        int count = 0;
        try {
            count = runner.execute(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

}
