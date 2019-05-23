package online.suiyu.servlet;

import online.suiyu.service.impl.TodoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/admin/user/update-todo"})
public class ToDoListUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String todo = req.getParameter("todo");
        TodoServiceImpl todoService = new TodoServiceImpl();
        Boolean flag = todoService.updateTodo(todo);
        PrintWriter printWriter = resp.getWriter();
        if (flag) {
            printWriter.println(1);
        } else {
            printWriter.println(0);
        }
        printWriter.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
