package online.yuluo.consumer.controller;

import online.yuluo.consumer.remote.RemoteServer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class RemoteServerImpl implements RemoteServer {
    @Override
    public String remoteHello(@RequestParam("name") String name) {
        return "Hello,"+name+".When you see this message," +
                "there are some problem with the remote server you call!";
    }
}
