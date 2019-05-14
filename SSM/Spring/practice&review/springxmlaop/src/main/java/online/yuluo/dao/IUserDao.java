package online.yuluo.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    void saveUser();

    void updateUser();
}
