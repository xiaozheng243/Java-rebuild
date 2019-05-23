package online.suiyu.servlet;


import online.suiyu.domain.Classify;
import online.suiyu.service.impl.ClassifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/post/admin/manage-classify"})
public class ManageClassifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String cid = req.getParameter("cid");
        String manage = req.getParameter("manage");
        String cname = req.getParameter("cname");
        System.out.println(cid + "\t" + manage + "\t" + cname);
        System.out.println("开启修改分类");
        Classify classify = new Classify();
        PrintWriter printWriter = resp.getWriter();
        classify.setcName(cname);
        boolean flag = false;
        if (manage.equals("1")) {
            //修改
            classify.setcId(Integer.parseInt(cid));
            flag = new ClassifyServiceImpl().updateClassify(classify);
        } else if (manage.equals("2")) {
            //删除
            classify.setcId(Integer.parseInt(cid));
            flag = new ClassifyServiceImpl().deleteClassify(classify);
        } else if (manage.equals("3")) {
            //添加分类
            flag = new ClassifyServiceImpl().addClassify(classify);
        }
        if (flag) {
            printWriter.println(1);
        } else {
            printWriter.println(0);
        }
        printWriter.close();
    }
}
