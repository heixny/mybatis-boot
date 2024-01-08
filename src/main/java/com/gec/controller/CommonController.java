package com.gec.controller;

import com.gec.domain.R;
import com.gec.domain.Router;
import com.gec.domain.User;
import com.gec.service.impl.BaseService;
import com.gec.service.it.LoginService;
import com.gec.service.it.UserService;
import com.gec.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Common")
public class CommonController extends BaseController<User>{
    @Autowired
    private UserService service;
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login1")
    public Map login1(@RequestBody Map map){
        String account= (String) map.get("account");
        String password= (String) map.get("password");
        System.out.println("用户登录");
        //临时的
        User user=null;
        try{
            //获取用户信息
            user=service.doLogin(account,password);
            Map data=new HashMap();
            //将用户发过去
            data.put("user",user);
            //再将token发过去
            data.put("token","sss");
            return sendData(data);
        }catch (Exception e){
            return sendError(e);
        }
    }
    @RequestMapping("/login")
    public Map login(@RequestBody Map map){
        String account = (String)map.get("account");
        String password = (String)map.get("password");
        printLogin(account, password);
        User user = loginService.login(account, password);
//        System.out.println(user);
        Map data = new HashMap();
        data.put("userId", user.getId());
        String JWT = JwtUtils.generateJWT( data );
        return R.OK()
                .add("userId", user.getId())
                .add("token", JWT)
                .add("role",user.getNo())
                .map();
    }
    @RequestMapping("/getRouteList")
    public Map getRouteList(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println("+-----------------------+");
        System.out.println("[TOKEN]"+ token);
        System.out.println("+-----------------------+");
        List<Router> routers = Router.testData();
        return sendData( routers );
    }
    @RequestMapping("/logout")
    public Map logout(){
        loginService.logout();
        return R.OK()
                .map();
    }
    void printLogin(String account, String password){
        System.out.println("+-------------------[login]-------------------+");
        System.out.println("account="+ account);
        System.out.println("password="+ password);
        System.out.println("+---------------------------------------------+");
    }
    @Override
    protected BaseService<User> getService() {
        return null;
    }
}
