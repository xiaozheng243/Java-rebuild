package online.suiyu.servlet;

import online.suiyu.dao.impl.CommentDaoImpl;
import online.suiyu.domain.Comment;
import online.suiyu.domain.Post;
import online.suiyu.service.impl.CommentServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/admin/post/comment-manage"})
public class ManageCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String manage = req.getParameter("manage");
        String aid = req.getParameter("aid");
        Comment comment = new Comment();
        comment.setCid(Integer.parseInt(aid));
        PrintWriter printWriter = resp.getWriter();
        boolean flag = false;
        if (manage.equals("3")) {
            //删除
            flag = new CommentServiceImpl().deleteComment(comment);
        }
        if (flag) {
            printWriter.println(1);
        } else {
            printWriter.println(0);
        }
        printWriter.close();
    }
}
