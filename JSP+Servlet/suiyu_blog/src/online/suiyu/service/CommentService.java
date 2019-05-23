package online.suiyu.service;

import online.suiyu.domain.Comment;
import online.suiyu.domain.CommentDemo;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;

import java.util.List;

public interface CommentService {
    public boolean insertComment(Comment comment);

    public boolean deleteComment(Comment comment);

    public List<Comment> getComments();

    public List<Comment> getCommentsByAid(PostDemo post);

    public List<CommentDemo> getCommentDemo();
}
