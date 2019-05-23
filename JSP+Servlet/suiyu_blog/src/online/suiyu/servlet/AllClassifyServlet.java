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
import java.util.*;

@WebServlet(urlPatterns = {"/admin/post/classify"})
public class AllClassifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Classify> classifies = new ClassifyServiceImpl().getAllClassify();
        req.setAttribute("classifies", classifies);
        req.getRequestDispatcher("/admin/classifies.jsp").forward(req, resp);
    }
}
