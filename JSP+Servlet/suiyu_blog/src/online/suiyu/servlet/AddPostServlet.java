package online.suiyu.servlet;

import online.suiyu.domain.Post;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/admin/post/add"})
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String title = req.getParameter("posttitle");
        String post = req.getParameter("post");
        String astate = req.getParameter("astate");
        String classify = req.getParameter("classify");
        PrintWriter printWriter = resp.getWriter();
        System.out.println(post);
        System.out.println(astate);
        System.out.println(classify);
        Post post1 = new Post();
        post1.setTitle(title);
        post1.setDetails(post);
        post1.setStateid(Integer.parseInt(astate));
        post1.setClassify(Integer.parseInt(classify));
        new PostServiceImpl().addPost(post1);
        printWriter.println(1);
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
