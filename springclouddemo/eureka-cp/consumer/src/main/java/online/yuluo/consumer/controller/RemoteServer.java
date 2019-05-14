package online.yuluo.consumer.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer")
public interface RemoteServer {

    @RequestMapping(value = "/index/getString")
    String remoteHello(@RequestParam("name") String name);
}
