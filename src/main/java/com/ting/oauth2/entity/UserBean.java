package com.ting.oauth2.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户信息
 *
 * @author lishuang
 * @version 1.0
 * @date 2023/03/10 15:47
 */
@Data
public class UserBean implements UserDetails {

    private String userId;

    private String username;

    private String password;

    private Integer isLock;

    private Integer isExpired;

    private Integer isEnabled;

    private String phone;

    private String idNumber;

    private Integer sex;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
