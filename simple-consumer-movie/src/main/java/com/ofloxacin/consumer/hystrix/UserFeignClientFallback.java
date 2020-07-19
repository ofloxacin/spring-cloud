package com.ofloxacin.consumer.hystrix;

import com.ofloxacin.consumer.feign.UserFeignClient;
import com.ofloxacin.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author chens
 **/
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @Override
    public Long addUser(User user) {
        return null;
    }
}
