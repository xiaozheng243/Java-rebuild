package online.suiyu.eurekaserverdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerdemo1Application.class, args);
    }
}
