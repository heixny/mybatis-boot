package com.gec.security;

import com.gec.domain.R;
import com.gec.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req,
        HttpServletResponse resp, AccessDeniedException e)
        throws IOException, ServletException {
        System.out.println("{DeniedHandler} 没有权限时, 返回消息..");
        Map map = R.ERR(403, R.MSG_403).map();
        WebUtils.write(resp,map);
    }

}
