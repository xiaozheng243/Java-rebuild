package online.suiyu.annotationaop.service.impl;

import online.suiyu.annotationaop.service.UserService;
import org.springframework.stereotype.Service;


@Service(value = "userService")
//@Aspect
public class UserServiceImpl implements UserService {
    @Override
//    @Before(value = "execution(public void online.suiyu.annotationaop.aspect.MyAspect.log())")
    public void save() {
        System.out.println("userService save");
    }

    @Override
    public void update() {
        System.out.println("userService update");
    }
}
