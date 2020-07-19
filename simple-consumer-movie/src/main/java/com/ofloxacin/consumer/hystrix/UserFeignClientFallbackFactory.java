package com.ofloxacin.consumer.hystrix;

import com.ofloxacin.consumer.feign.UserFeignClient;
import com.ofloxacin.consumer.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author chens
 **/
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user = new User();
                if (cause instanceof IllegalArgumentException) {
                    user.setId(-2L);
                } else {
                    user.setId(-1L);
                }
                user.setName("默认用户");
                return user;
            }

            @Override
            public Long addUser(User user) {
                return null;
            }
        };
    }
}
