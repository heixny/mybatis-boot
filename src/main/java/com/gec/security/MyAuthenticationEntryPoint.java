package com.gec.security;
import com.gec.domain.R;
import com.gec.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence( HttpServletRequest req,
         HttpServletResponse resp, AuthenticationException e )
         throws IOException, ServletException {
        String uri = req.getRequestURI();
        System.out.println("{EntryPoint} commence URI:"+ uri);
        System.out.println("{DeniedHandler} 没有登录时, 返回消息..");
        Map map = R.ERR(401, R.MSG_401).map();
        WebUtils.write( resp, map );
    }

}






