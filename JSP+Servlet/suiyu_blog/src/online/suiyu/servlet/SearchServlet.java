package online.suiyu.servlet;

import online.suiyu.domain.PostDemo;
import online.suiyu.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String search = req.getParameter("search");
//        System.out.println(search);
        ArrayList<PostDemo> searchList = new SearchServiceImpl().getPostsBySearch(search);
//        PrintWriter printWriter = resp.getWriter();
//        if (searchList != null || searchList.size() != 0) {
//            req.setAttribute("searchlist", searchList);
//            req.getRequestDispatcher("search-result.jsp").forward(req, resp);
////            resp.sendRedirect("/suiyu/search-result");
////            printWriter.println(1);
//        } else {
//
////            printWriter.println(0);
//        }
//        printWriter.close();
        req.setAttribute("searchlist", searchList);
        req.getRequestDispatcher("search-result.jsp").forward(req, resp);
    }
}
