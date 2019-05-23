package online.suiyu.servlet;

import online.suiyu.domain.Astate;
import online.suiyu.domain.Classify;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.impl.AstateServiceImpl;
import online.suiyu.service.impl.ClassifyServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/post/admin/managepost"})
public class ManagePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manage = req.getParameter("manage");
        String aid = req.getParameter("aid");
//        System.out.println(manage + "::" + aid);
        Post post = new Post();
        post.setAid(Integer.parseInt(aid));
        PrintWriter printWriter = resp.getWriter();
        boolean flag = false;
        if (manage.equals("1")) {
            //编辑
//            System.out.println("跳转到修改页面！");
//            req.getRequestDispatcher("/admin/modify-article.jsp").forward(req, resp);
            printWriter.println(2);
            return;
        } else if (manage.equals("2")) {
            //发布
            flag = new PostServiceImpl().changePost(post, 6001);
        } else if (manage.equals("3")) {
            //删除
            flag = new PostServiceImpl().removePost(post);
        } else if (manage.equals("4")) {
            //转为草稿
            flag = new PostServiceImpl().changePost(post, 6002);
        } else if (manage.equals("5")) {
            //真正的删除
            flag = new PostServiceImpl().deletePost(post);
        }
        if (flag) {
//            System.out.println("发布成功！");
            printWriter.println(1);
        } else {
            printWriter.println(0);
        }
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
