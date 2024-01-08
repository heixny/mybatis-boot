package com.gec.service.impl;

import com.gec.domain.Dept;
import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.mapper.BaseMapper;
import com.gec.mapper.DeptMapper;
import com.gec.mapper.UserMapper;
import com.gec.service.it.DeptService;
import com.gec.service.it.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper mapper;


    @Override
    public BaseMapper getBaseMap() {
        return mapper;
    }

    @Override
    public User doLogin(String account, String password) {
        User dbUser=mapper.getUserByAccount(account);
        if (dbUser!=null){
            String ps=dbUser.getPassword();
            if (ps.equals(password)){
                return dbUser;
            }
        }
        throw new RuntimeException("用户登录失败");
    }

    @Override
    public void saveUser(User user) {
        String id=user.getId();
//        System.out.println("id:"+id+",length:"+id.length());
        if(id!=null&&id.length()!=0) {
            //比较密码是否一致或匹配
            User ubi = mapper.getUserById(user.getId());
            String password = ubi.getPassword();
            comparePassword(user,password);
            mapper.updateUser(user);
        }else {
            user.setId(createUUID(4));
            //将密码加密
            converPassword(user);
            int c=mapper.addUser(user);
//            System.out.println("+-------------52"+c);
        }
    }

    private void comparePassword(User user, String password) {
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        boolean matches = e.matches(user.getPassword(), password);
//        System.out.println(matches);
        if (user.getPassword().equals(password)||matches){
            user.setPassword(null);
            return ;
        }else{
            String encode = e.encode(user.getPassword());
            user.setPassword(encode);
            return ;
        }
    }

    private void converPassword(User user) {
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        String PS = e.encode(user.getPassword());
        user.setPassword(PS);
    }

    @Override
    public void delUser(String id) {
        if(id!=null) {
            int c=mapper.delUser(id);
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public User getUserById(String id) {
        User user=null;
        user=mapper.getUserById(id);
        return user;
    }
}
