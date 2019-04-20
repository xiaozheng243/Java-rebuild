package online.yuluo.consumer.controller;

import online.yuluo.consumer.remote.RemoteServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private RemoteServer remoteServer;

    @RequestMapping(value = "/getRemoteString/{name}", method = RequestMethod.GET)
    public String getString(@PathVariable("name") String name) {
        return remoteServer.remoteHello(name);
    }
}
