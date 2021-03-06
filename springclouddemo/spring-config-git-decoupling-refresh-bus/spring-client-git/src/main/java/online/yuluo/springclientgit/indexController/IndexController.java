package online.yuluo.springclientgit.indexController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // springcloud配置中心刷新时自动更新
public class IndexController {

    @Value("${province.name}")
    private String provinceName;

    @RequestMapping(value = "/getProvince", method = RequestMethod.GET)
    public String getProvinceName() {
        return this.provinceName;
    }
}
