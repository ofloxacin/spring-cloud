package com.ofloxacin.provider.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chens
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new User("user", "password1", authorities("user-role"));
        } else if ("admin".equals(username)) {
            return new User("admin", "password2", authorities("admin-role"));
        } else {
            return null;
        }
    }

    private List<GrantedAuthority> authorities(String... role) {
        return Arrays.stream(role).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
