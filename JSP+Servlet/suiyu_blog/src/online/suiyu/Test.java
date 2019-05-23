package online.suiyu;

import online.suiyu.domain.PostDemo;
import online.suiyu.service.PostService;
import online.suiyu.service.UserService;
import online.suiyu.service.impl.PostServiceImpl;
import online.suiyu.service.impl.UserServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ParseException {

        //测试登录
        UserService userService = new UserServiceImpl();
        System.out.println(userService.login("suiyu", "suiyu123"));


        //测试接收post
//        PostService postService = new PostServiceImpl();
//        ArrayList<PostDemo> list = postService.getPostsForPublish();
//        for (PostDemo postDemo : list) {
//            System.out.println(postDemo);
//        }
    }
}
