package online.yuluo.yuluoblog.online.yuluo.feign.impl;

import online.yuluo.yuluoblog.online.yuluo.entity.UserInfoVO;
import online.yuluo.yuluoblog.online.yuluo.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HelloRemoteImpl implements HelloRemote {
    @Override
    public UserInfoVO getUserById(@PathVariable("id") int id) {
        return new UserInfoVO();
    }
}
