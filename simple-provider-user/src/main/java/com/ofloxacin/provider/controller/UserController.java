package com.ofloxacin.provider.controller;

import com.ofloxacin.provider.dao.UserRepository;
import com.ofloxacin.provider.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author chenshuai
 * @date 2020/07/18
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = (UserDetails) principal;
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        authorities.forEach(auth -> log.info("当前用户:{},角色:{}", user.getUsername(), auth.getAuthority()));
        return userRepository.getOne(id);
    }

    @PostMapping("/user/add")
    public Long add(@RequestBody User user) {
        return userRepository.save(user).getId();
    }
}
