package com.consumer.controller;

import com.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenshuai
 * @date 2020/07/18
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }
}
