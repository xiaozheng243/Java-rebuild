package online.suiyu.servlet;

import online.suiyu.domain.Classify;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.impl.ClassifyServiceImpl;
import online.suiyu.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/categorys"})
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Classify> classifies = new ClassifyServiceImpl().getAllClassify();
        Map<Classify, List<PostDemo>> map = new HashMap<>();
        for (Iterator<Classify> iterator = classifies.iterator(); iterator.hasNext(); ) {
            Classify classify = iterator.next();
            List<PostDemo> list = new PostServiceImpl().getPostForClassify(classify);
            map.put(classify, list);
        }
        req.setAttribute("category", map);
        req.getRequestDispatcher("categorys.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
