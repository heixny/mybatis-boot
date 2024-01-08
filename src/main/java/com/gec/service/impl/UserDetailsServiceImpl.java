package com.gec.service.impl;

import com.gec.domain.User;
import com.gec.mapper.UserMapper;
import com.gec.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    private UserMapper mapper;

    Map<String,User> Base=new HashMap();
    List<String> permissions=new ArrayList();
    //模拟数据库
//    {
//        System.out.println("{UserDetailsServiceImpl}初始化用户...");
//        permissions.add("dept:view");
//        permissions.add("dept:edit");
//    }
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        //模拟根据用户名获取数据库中的用户
        User user=mapper.getUserByAccount(account);
        System.out.println(user);
        if (user==null){
            throw new RuntimeException("用户不存在");
        }
        return new UserDetailImpl(user,permissions);
    }
}
