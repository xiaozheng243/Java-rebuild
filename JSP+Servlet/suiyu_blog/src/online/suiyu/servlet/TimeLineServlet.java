package online.suiyu.servlet;

import online.suiyu.domain.PostDemo;
import online.suiyu.service.PostService;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/time-line"})
public class TimeLineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PostService postService = new PostServiceImpl();
        ArrayList<PostDemo> publish = postService.getPostsForPublish();
        req.setAttribute("publishArticles", publish);
        req.getRequestDispatcher("timeline.jsp").forward(req, resp);

    }
}
