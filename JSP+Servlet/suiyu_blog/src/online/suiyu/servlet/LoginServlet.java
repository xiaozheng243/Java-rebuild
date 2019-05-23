package online.suiyu.servlet;

import online.suiyu.domain.User;
import online.suiyu.service.UserService;
import online.suiyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String checkbox = req.getParameter("checkbox");
//        System.out.println(username + "::" + password + "::" + checkbox);
        PrintWriter printWriter = resp.getWriter();
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            printWriter.println("1");
        } else {
            printWriter.println("0");
        }
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
