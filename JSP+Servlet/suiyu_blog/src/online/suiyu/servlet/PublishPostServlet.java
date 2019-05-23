package online.suiyu.servlet;

import online.suiyu.domain.Post;
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

@WebServlet(urlPatterns = {"/admin/post/publish"})
public class PublishPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostServiceImpl();
        ArrayList<PostDemo> publish = postService.getPostsForPublish();
        req.setAttribute("publishArticles", publish);
        req.getRequestDispatcher("/admin/publish-article.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
