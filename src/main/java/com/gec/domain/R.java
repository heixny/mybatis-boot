package com.gec.domain;

import java.util.HashMap;
import java.util.Map;


public class R {
    Map map=new HashMap();
    public static final String MSG_401 = "你没有登录, 请登录";
    public static final String MSG_403 = "你没有权限, 请确认角色。";
    public static R OK(){
        R r=new R();
        r.map.put("code",200);
        r.map.put("result","success");
        return r;
    }
    public static R ERR(Exception e){
        R r=new R();
        r.map.put("code",500);
        r.map.put("result","failed");
        r.map.put("cause",e.getMessage());
        return r;
    }
    public static R ERR(int code, String msg){
        R r = new R();
        r.map.put("code",code);
        r.map.put("result","failed");
        r.map.put("cause",msg);
        return r;
    }
    public R add(String K,Object V){
        this.map.put(K,V);
        return this;
    }
    public Map map(){
        return this.map;
    }

}
