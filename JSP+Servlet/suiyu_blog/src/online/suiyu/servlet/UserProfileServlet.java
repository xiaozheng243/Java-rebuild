package online.suiyu.servlet;

import online.suiyu.domain.User;
import online.suiyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/user/profile"})
public class UserProfileServlet extends HttpServlet {
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
        User user1 = (User) req.getSession().getAttribute("user");
        user.setUsername(user1.getUsername());
        user = new UserServiceImpl().getUserProfile(user);
        req.setAttribute("userprofile", user);
        req.getRequestDispatcher("/admin/author.jsp").forward(req, resp);
    }
}