package online.suiyu.servlet;

import online.suiyu.domain.Comment;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.CommentService;
import online.suiyu.service.PostService;
import online.suiyu.service.impl.CommentServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/post"})
public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        PostService postService = new PostServiceImpl();
        CommentService service = new CommentServiceImpl();
        PostDemo postDemo = postService.getPostForOne(Integer.parseInt(id));
        List<Comment> commentList = service.getCommentsByAid(postDemo);
        req.setAttribute("onepost", postDemo);
        req.setAttribute("commentList", commentList);
        req.getRequestDispatcher("article.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}