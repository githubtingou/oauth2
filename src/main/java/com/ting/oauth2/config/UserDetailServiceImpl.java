package com.ting.oauth2.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * security获取用户
 *
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 15:45
 */
@Service(value = "userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户信息
        return new User("", "", new ArrayList<>());
    }

}
