package online.suiyu.service.impl;

import online.suiyu.dao.CommentDao;
import online.suiyu.dao.impl.CommentDaoImpl;
import online.suiyu.domain.Comment;
import online.suiyu.domain.CommentDemo;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();

    @Override
    public boolean insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public boolean deleteComment(Comment comment) {
        return commentDao.deleteComment(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentDao.getComments();
    }

    @Override
    public List<Comment> getCommentsByAid(PostDemo post) {
        return commentDao.getCommentsByAid(post);
    }

    @Override
    public List<CommentDemo> getCommentDemo() {
        return commentDao.getCommentDemo();
    }
}
