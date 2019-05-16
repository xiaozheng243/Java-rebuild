package online.yuluo.yuluoblog.online.yuluo.feign;

import online.yuluo.yuluoblog.online.yuluo.entity.UserInfoVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component
@FeignClient(name = "eureka-client")
public interface HelloRemote {
    @RequestMapping(value = "/user/getUserById/{id}", method = RequestMethod.GET)
    UserInfoVO getUserById(@PathVariable("id") int id);
}
