package com.gec.security;

import com.gec.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Resource(name="redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取请求头的token
        String token = req.getHeader("token");
        //如果为空放行
        if (token==null||token.isEmpty()){
            chain.doFilter(req,resp);
            return;
        }
        //解析JwtToken
        Claims claims= JwtUtils.parseJWT(token);
        //获取userId
        String userId = (String) claims.get("userId");
        String key="user:"+userId;


        System.out.println(key);
        //创建redis
        ValueOperations<String, Object> OP = redisTemplate.opsForValue();
        //用userId从Redis获取userDetail
        UserDetailImpl userDetail = (UserDetailImpl) OP.get(key);
        //获取userToken
        Authentication userToken =new UsernamePasswordAuthenticationToken(userDetail,null,userDetail.getAuthorities());
        //将Usertoken设置进security中
        SecurityContextHolder.getContext()
                            .setAuthentication(userToken);
        //放行
        chain.doFilter(req,resp);
    }
}
