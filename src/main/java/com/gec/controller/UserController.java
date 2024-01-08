package com.gec.controller;

import com.gec.domain.Dept;
import com.gec.domain.PageParam;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;
import com.gec.service.it.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController extends BaseController<User>{
    @Autowired
    private UserService service;
    @RequestMapping("/list")
    @ResponseBody
    public Map jsonList(@RequestBody Map map){
        return super.list(map);
    }

    @Override
    protected BaseService<User> getService() {
        return service;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public Map saveUser(@RequestBody User user) {
        try {
//            System.err.println(user);
            service.saveUser(user);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/getUser")
    @ResponseBody
    public Map getUser(@RequestBody String id)
            throws IOException, ServletException {
        User user=null;
        System.out.println(id);
        try {
//            user=service.getUserById(id);
            return sendData(user);
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
    @RequestMapping("/delUser")
    @ResponseBody
    public Map delUser(@RequestBody Map map){
        String id= (String) map.get("id");
        try {
            service.delUser(id);
            return sendSuccess();
        }catch(Exception e) {
            e.printStackTrace();
            return sendError(e);
        }
    }
}
