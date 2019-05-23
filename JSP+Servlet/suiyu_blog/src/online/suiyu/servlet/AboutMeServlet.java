package online.suiyu.servlet;

import online.suiyu.domain.User;
import online.suiyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/about-me"})
public class AboutMeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = new User();
//        String username = (String) req.getSession().getAttribute("username");
        user.setUsername("suiyu");
        user = new UserServiceImpl().getUserProfile(user);
        req.setAttribute("user", user);
        req.getRequestDispatcher("aboutme.jsp").forward(req, resp);
    }
}
