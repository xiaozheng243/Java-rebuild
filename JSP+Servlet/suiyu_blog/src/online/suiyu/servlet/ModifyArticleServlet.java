package online.suiyu.servlet;

import online.suiyu.domain.Astate;
import online.suiyu.domain.Classify;
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
import java.util.List;

@WebServlet(urlPatterns = {"/post/admin/modify-post"})
public class ModifyArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String aid = req.getParameter("aid");
        PostDemo postDemo = new PostServiceImpl().getPostForOne(Integer.parseInt(aid));
        System.out.println(postDemo);
        req.setAttribute("modifypost", postDemo);
        List<Astate> astate = new AstateServiceImpl().getAllState();
        req.setAttribute("state", astate);
        List<Classify> classifies = new ClassifyServiceImpl().getAllClassify();
        req.setAttribute("classify", classifies);
        req.getRequestDispatcher("/admin/modify-article.jsp").forward(req, resp);
    }
}
