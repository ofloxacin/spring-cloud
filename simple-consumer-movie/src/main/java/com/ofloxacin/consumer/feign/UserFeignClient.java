package com.ofloxacin.consumer.feign;

import com.ofloxacin.consumer.hystrix.UserFeignClientFallbackFactory;
import com.ofloxacin.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chens
 **/
@FeignClient(value = "provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable Long id);

    @PostMapping("/user/add")
    Long addUser(@RequestBody User user);
}
