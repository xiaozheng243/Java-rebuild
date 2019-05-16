package online.yuluo.yuluoblog.online.yuluo.feign;

import online.yuluo.yuluoblog.online.yuluo.entity.UserInfoVO;
import online.yuluo.yuluoblog.online.yuluo.feign.impl.HelloRemoteImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Primary
@FeignClient(name = "eureka-client",fallback = HelloRemoteImpl.class)
public interface HelloRemote {
    @RequestMapping(value = "/user/getUserById/{id}", method = RequestMethod.GET)
    UserInfoVO getUserById(@PathVariable("id") int id);
}
