package com.gec.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebUtils {

    public static void write(HttpServletResponse resp, Map map)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String s = JSONObject.toJSONString(map);
        resp.getWriter().write( s );
    }

    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        String s = JSONObject.toJSONString(map);
        System.out.println( s );
    }


}
