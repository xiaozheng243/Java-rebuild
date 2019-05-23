package online.suiyu.servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import online.suiyu.domain.User;
import online.suiyu.service.impl.UploadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/admin/upload"})
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String filePath = getServletContext().getRealPath("/") + "dist/img";
        System.out.println(filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //实例化上传组件
        SmartUpload su = new SmartUpload();
        //初始化SmartUpload
        su.initialize(getServletConfig(), req, resp);
        //设置上传文件对象10M
        su.setMaxFileSize(1024 * 1024 * 10);
        //设置所有文件大小100M
        su.setTotalMaxFileSize(1024 * 1024 * 100);
        //设置允许上传文件类型
        su.setAllowedFilesList("jpg,gif,png");
        String result = "上传成功！";
        try {
            //设置禁止上传文件类型
            su.setDeniedFilesList("rar,jsp,js");
            //上传文件
            su.upload();
            //保存文件
            su.save(filePath);
        } catch (Exception e) {
            result = "上传失败！";
            e.printStackTrace();
        }
        if (file.exists()) {
            file.delete();
        }
        //获取上传的文件
        com.jspsmart.upload.File tempFile = su.getFiles().getFile(0);
        //获取上传文件的表单当中的name值
        tempFile.getFieldName();
        //获取上传的文件名
        System.out.println(tempFile.getFileName());
        //获取上传文件的大小
        tempFile.getSize();
        //获取上传文件的后缀名
        tempFile.getFileExt();
        //获取上传文件的全名
        tempFile.getFilePathName();
        User user = (User) req.getSession().getAttribute("user");
        user.setPhoto(tempFile.getFileName());
        Boolean flag = new UploadServiceImpl().changePhoto(user);
//        new UploadServiceImpl().changePhoto(filePath, tempFile.getFileName(), tempFile.getFileExt());
        if (flag){
            System.out.println("执行完成！");
            req.setAttribute("result", 1);
        }else{
            req.setAttribute("result", 0);
        }

        resp.sendRedirect("/suiyu/admin/user/upload");
    }
}
