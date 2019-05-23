package online.suiyu.servlet;

import online.suiyu.domain.User;
import online.suiyu.service.impl.UserServiceImpl;
import online.suiyu.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

@WebServlet(urlPatterns = {"/admin/user/update"})
public class UpdateUserProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        System.out.println("更新信息！");
        User user = new User();
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String upassword = req.getParameter("password");
        String email = req.getParameter("email");
//        String birth = req.getParameter("birth");
        String usign = req.getParameter("sign");
        String github = req.getParameter("github");
        String disc = req.getParameter("disc");
//        String photo = req.getParameter("photo");
        DateUtils dateUtils = new DateUtils();
//        user.setPhoto(photo);
        user.setId(Integer.parseInt(id));
        user.setGithub(github);
        user.setDisc(disc);
        user.setUsername(username);
        user.setUpassword(upassword);
        user.setEmail(email);
        user.setUsign(usign);
        System.out.println(user);
        boolean flag = new UserServiceImpl().updateUser(user);
        printWriter.println(flag ? 1 : 0);
        printWriter.close();
    }
}
