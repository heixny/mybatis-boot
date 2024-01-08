package com.gec.security;


import com.gec.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailImpl implements UserDetails {
    //存入到Redis中
    private User user;
    //权限列表[数据库中]--->存入Redis
    private List<String> permissions;
    //权限列表[给security用的]
    private List<SimpleGrantedAuthority> authorities;

    public UserDetailImpl(){}
    public UserDetailImpl(User user,List<String> permissions){
        this.user=user;
        //登录后调用方法
        setPermissions(permissions);
    }
    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user = user;
    }
    //+-----------------------------------------------------------+
    public void setPassword(String password){ }
    public void setEnabled(boolean enabled){ }
    public void setUsername(String username){ }
    public void setCredentialsNonExpired(String username){ }
    public void setAccountNonExpired(boolean flag){ }
    public void setAccountNonLocked(boolean flag){ }
    //+-----------------------------------------------------------+

    public List<String> getPermissions(){
        return this.permissions;
    }

    //从Redis中取出对象时，会调用方法
    private void setPermissions(List<String> permissions) {
        this.permissions=permissions;
        List list=new ArrayList();
        for (String P:permissions) {
            SimpleGrantedAuthority auth=new SimpleGrantedAuthority(P);
            list.add(auth);
        }
//        this.authorities=list;

    }



    //返回权限给spring security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getAccount();
    }
    //账号是否不过期 true=没过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //这个账号是否不过期  true=没有锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //密码是否不过期 true=不过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
