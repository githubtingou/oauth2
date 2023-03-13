package com.ting.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 15:55
 */
@Configuration
public class SecurityConfig {

    @Autowired
    @Qualifier(value = "userDetailServiceImpl")
    private UserDetailsService userDetailService;

    @Autowired
    @Qualifier(value = "loginSuccessHandle")
    private AuthenticationSuccessHandler loginSuccessHandle;

    @Autowired
    @Qualifier(value = "loginFailureHandle")
    private AuthenticationFailureHandler loginFailureHandle;

    /**
     * 鉴权操作
     *
     * @param security
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests()
                .antMatchers("auth/**").permitAll()
                // 拦截其他所有未放行的接口地址
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("auth/login")
                .successHandler(loginSuccessHandle)
                .failureHandler(loginFailureHandle)
                .and()
                .userDetailsService(userDetailService)
                .passwordManagement(config -> config.changePasswordPage("/auth/changePassword"))
        ;

        return security.build();
    }


    /**
     * 密码管理器
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
