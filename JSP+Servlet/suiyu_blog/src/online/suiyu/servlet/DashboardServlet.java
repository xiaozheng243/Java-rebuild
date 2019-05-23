package online.suiyu.servlet;

import online.suiyu.domain.Classify;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.impl.ClassifyServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;
import online.suiyu.service.impl.TodoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin/dashboard"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //分类及文章
        List<Classify> classifies = new ClassifyServiceImpl().getAllClassify();
        Map<Classify, List<PostDemo>> map = new HashMap<>();
        for (Iterator<Classify> iterator = classifies.iterator(); iterator.hasNext(); ) {
            Classify classify = iterator.next();
            List<PostDemo> list = new PostServiceImpl().getPostForClassify(classify);
            map.put(classify, list);
        }
        req.setAttribute("category", map);

        //已发布文章
        ArrayList<PostDemo> publish = new PostServiceImpl().getPostsForPublish();
        req.setAttribute("publishArticles", publish);
        String todos = new TodoServiceImpl().getTodo();
        if (todos != null && !todos.equals("")) {
            String[] todo = todos.split(";");
            req.setAttribute("todo", todo.length);
        } else {
            req.setAttribute("todo", 0);
        }
        //草稿箱
        ArrayList<PostDemo> draft = new PostServiceImpl().getPostsForDraft();
        req.setAttribute("draftArticles", draft);
        req.getRequestDispatcher("/admin/dashboard.jsp").forward(req, resp);
    }
}
