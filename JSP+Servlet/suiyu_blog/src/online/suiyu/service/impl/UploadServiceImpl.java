package online.suiyu.service.impl;

import online.suiyu.dao.impl.UserDaoImpl;
import online.suiyu.domain.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadServiceImpl {
    public boolean changePhoto(User user) {
        return new UserDaoImpl().updateUser(user);
//        File srcFile = new File(path, name);
//        File distFile = new File("D:/suiyu_blog/web/dist/img/lzz." + fileExt);
//        System.out.println(distFile.getAbsolutePath());
//        if (!distFile.exists()) {
//            distFile.createNewFile();
//        }
//        FileInputStream inputStream = new FileInputStream(srcFile);
//        FileOutputStream fileOutputStream = new FileOutputStream(distFile);
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while ((len = inputStream.read(bytes)) != -1) {
//            fileOutputStream.write(bytes, 0, len);
//        }
//        System.out.println("跳转完成！");

    }
}
