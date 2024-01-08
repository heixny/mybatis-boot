package com.gec.controller;

import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;
import com.gec.utils.JwtUtils;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class BaseController<T> {
    protected PageParam getPageParam(Map map){
        int page=getInt("page",map,1);
        int limit=getInt("limit",map,10);
        System.out.printf("page:%s,limit:%s\n",page,limit);
        return new PageParam(page, limit);
    }

    public int getInt(String K,Map map,int defVal){
        Object V=map.get(K);
        if (V!=null){
            if (V instanceof Integer){
                return (Integer) V;
            }else if (V instanceof String){
                String V2= (String) V;
                if (V2.length()!=0){
                    return Integer.valueOf(V2);
                }
            }
        }
        return defVal;
    }
    protected Map sendData(Object list) {
        Map ret=new HashMap();
        ret.put("result","success");
        ret.put("data",list);
        return ret;
    }
    protected Map sendSuccess() {
        Map ret=new HashMap();
        ret.put("result","success");
        return ret;
    }
    protected Map sendError(Exception e){
        Map ret=new HashMap();
        ret.put("result","failed");
        ret.put("code",0);
        ret.put("cause",e.getMessage());
        return ret;
    }
    protected String makeURLMsg(String msg) {
        String _msg=null;
        try {
            _msg= URLEncoder.encode(msg,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return msg;
    }
    public String getuserId(HttpServletRequest req){
        String token = req.getHeader("token");
        //解析JwtToken
        Claims claims= JwtUtils.parseJWT(token);
        //获取userId
        String userId = (String) claims.get("userId");
        return userId;
    }
    public Map list(Map map){
        PageParam param = getPageParam(map);
        //未完工
        Map keywords=getKeywords(map);
        PageInfo<T> pInfo=getService().getPageList(param,keywords);
        return sendData(pInfo);
    }
    protected abstract BaseService<T> getService();

    private Map getKeywords(Map map){
        Set<String> set = map.keySet();
        Map<String,Object> keywords=new HashMap();
        for (String keys:set
             ) {
            Object value=map.get(keys);
            System.out.printf("key:%s,value:%s",keys,value);
            System.out.println();
            if (!keys.equals("limit")&&!keys.equals("page")&&!keys.equals("ran")){
                keywords.put(keys,value);
            }
        }
        return keywords;
    }
}
