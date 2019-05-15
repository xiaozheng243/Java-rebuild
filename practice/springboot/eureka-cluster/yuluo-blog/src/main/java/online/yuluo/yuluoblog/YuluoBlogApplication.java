package online.yuluo.yuluoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YuluoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuluoBlogApplication.class, args);
    }

}
