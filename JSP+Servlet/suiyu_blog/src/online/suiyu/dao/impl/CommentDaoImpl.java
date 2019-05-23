package online.suiyu.dao.impl;

import online.suiyu.dao.CommentDao;
import online.suiyu.domain.Comment;
import online.suiyu.domain.CommentDemo;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    //    private DataSourceUtils dataSourceUtils = new DataSourceUtils();
    private QueryRunner runner = new QueryRunner();

    @Override
    public boolean insertComment(Comment comment) {
        String sql = "insert into comment(cdetails,aid,commentUser) values(?,?,?)";
        Connection connection = DataSourceUtils.getConnection();
        Object[] params = {comment.getCdetails(), comment.getAid(), comment.getCommentUser()};
        int count = 0;
        try {
            count = runner.execute(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        String sql = "delete from comment where cid=?";
        Object[] params = {comment.getCid()};
        int count = 0;
        try {
            count = runner.execute(DataSourceUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    @Override
    public List<Comment> getComments() {
        String sql = "select * from comment";
        List<Comment> list = null;
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Comment>(Comment.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    *     private int cid;
        private String cdetails;
        private String atitle;
        private String commentUser;
        private Date creation;
    *
    * */
    @Override
    public List<CommentDemo> getCommentDemo() {
        String sql = "select comment.cid,comment.cdetails,post.title,comment.commentUser,comment.creation from comment,post where comment.aid=post.aid";
        List<CommentDemo> list = null;
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<CommentDemo>(CommentDemo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过文章ID返回评论
     *
     * @param postDemo
     * @return
     */
    @Override
    public List<Comment> getCommentsByAid(PostDemo postDemo) {
        String sql = "select * from comment where aid=?";
        List<Comment> list = null;
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Comment>(Comment.class), postDemo.getAid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
