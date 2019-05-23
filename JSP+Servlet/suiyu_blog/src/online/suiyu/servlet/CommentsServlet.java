package online.suiyu.servlet;

import online.suiyu.domain.Comment;
import online.suiyu.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/add-comment"})
public class CommentsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String comment = req.getParameter("comment");
        String aid = req.getParameter("aid");
        PrintWriter printWriter = resp.getWriter();
        Comment comment1 = new Comment();
        comment1.setCdetails(comment);
        comment1.setAid(Integer.parseInt(aid));
        comment1.setCommentUser(username);
        boolean flag = new CommentServiceImpl().insertComment(comment1);
        printWriter.println(flag ? 1 : 0);
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
