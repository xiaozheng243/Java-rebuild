package online.yuluo.consumer.remote;

import online.yuluo.consumer.controller.RemoteServerImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(name = "producer",fallback = RemoteServerImpl.class)
public interface RemoteServer {

    @RequestMapping(value = "/index/getString")
    String remoteHello(@RequestParam("name") String name);
}
