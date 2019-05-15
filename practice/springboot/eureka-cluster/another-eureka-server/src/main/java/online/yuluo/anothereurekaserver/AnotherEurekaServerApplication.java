package online.yuluo.anothereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnotherEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnotherEurekaServerApplication.class, args);
    }

}
