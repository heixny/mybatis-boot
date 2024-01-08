package com.gec.service.impl;

import com.gec.domain.User;
import com.gec.security.UserDetailImpl;
import com.gec.service.it.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource(name="redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private AuthenticationManager manager;

    @Override
    public User login(String account, String password) {
        System.out.printf("account:%s,password:%s\n",account,password);
        Authentication token=new UsernamePasswordAuthenticationToken(account,password);
        //authc封装了一个UserDetail对象，调用了loadUserByUsername
        System.out.println("Authentication");
        Authentication authc = manager.authenticate(token);
        System.out.println("UserDetailImpl");
        UserDetailImpl userDetail= (UserDetailImpl) authc.getPrincipal();
        System.out.println("User");
        User user=userDetail.getUser();
        //将用户信息存入Redis
        ValueOperations<String, Object> OP = redisTemplate.opsForValue();
        String KEY="user:"+user.getId();
        OP.set(KEY,userDetail,60*60, TimeUnit.SECONDS);
        return user;
    }

    @Override
    public void logout() {
        Authentication authc = SecurityContextHolder.getContext().getAuthentication();
        UserDetailImpl us= (UserDetailImpl) authc.getPrincipal();
        String id = us.getUser().getId();
        System.out.println(id);
        redisTemplate.delete("user:"+id);
    }
}
