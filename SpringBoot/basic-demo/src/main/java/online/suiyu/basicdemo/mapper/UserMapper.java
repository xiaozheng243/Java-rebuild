package online.suiyu.basicdemo.mapper;

import online.suiyu.basicdemo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Configuration
@Mapper
public interface UserMapper {

    @Bean
    List<User> selectAll();
}
