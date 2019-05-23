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

@WebServlet(urlPatterns = {"/admin/post/update-post"})
public class UpdatePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");          //设置编码格式
        resp.setCharacterEncoding("utf-8");         //设置编码格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String aid = req.getParameter("postid");
        String title = req.getParameter("posttitle");
        String post = req.getParameter("post");
        String astate = req.getParameter("astate");
        String classify = req.getParameter("classify");
        Post post1 = new Post();
        post1.setAid(Integer.parseInt(aid));
        post1.setTitle(title);
        post1.setDetails(post);
        post1.setStateid(Integer.parseInt(astate));
        post1.setClassify(Integer.parseInt(classify));
        if (new PostServiceImpl().updatePost(post1)){
            printWriter.println(1);
        }else{
            printWriter.println(0);
        }
        printWriter.close();
    }
}
