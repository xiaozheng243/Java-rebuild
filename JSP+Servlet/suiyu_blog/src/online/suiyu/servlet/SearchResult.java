package online.suiyu.servlet;

import online.suiyu.domain.PostDemo;
import online.suiyu.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/search-result"})
public class SearchResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");
//        ArrayList<PostDemo> searchList = new SearchServiceImpl().getPostsBySearch();
//        req.setAttribute("searchlist", searchList);
//        req.getRequestDispatcher("search-result.jsp").forward(req, resp);
    }
}
