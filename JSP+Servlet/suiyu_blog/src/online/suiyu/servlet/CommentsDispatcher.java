package online.suiyu.servlet;

import online.suiyu.domain.Comment;
import online.suiyu.domain.CommentDemo;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.PostService;
import online.suiyu.service.impl.CommentServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/admin/post/comments"})
public class CommentsDispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PostService postService = new PostServiceImpl();
        ArrayList<PostDemo> publish = postService.getPostsForPublish();
        req.setAttribute("publishArticles", publish);
        CommentServiceImpl commentService = new CommentServiceImpl();
        ArrayList<CommentDemo> commentDemo = (ArrayList<CommentDemo>) commentService.getCommentDemo();
        req.setAttribute("comments", commentDemo);
        req.getRequestDispatcher("/admin/comments-list.jsp").forward(req, resp);
    }
}
