package com.gec.config;
//记得解除注释
//import com.gec.util.FastJsonRedisSerializer;
import com.gec.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //{1}配置密码加密:[MD5]
    //数据库的密码是加密的
    //提交密码时，自动调用、加密
    public static void main(String[] args) {
        BCryptPasswordEncoder e = new BCryptPasswordEncoder();
        String PS = e.encode("admin");
        System.out.println( PS );
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        print("创建 [PasswordEncoder]");
        return new BCryptPasswordEncoder();
    }
    //{2}实例化认证管理器
    //认证token是否合法,返回认证信息类(UserDetail?)
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()
        throws Exception {
        print("创建 [AuthenticationManager]");
        return super.authenticationManagerBean();
    }
    //{3}认证过滤器 用户权限认证
    @Autowired
    private JwtAuthenticationFilter jwtAuthTokenFilter;

    @Autowired
    private AuthenticationEntryPoint authcEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    //{4}做配置的方法------关键！！！
    //同源策略配置(是否需要同源访问)http.csrf().disable(),不允许
    //配置可匿名访问，或权限认证、用户认证
    //注册过滤器、异常处理器
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        print("+----------------------------------------+");
        print("执行了配置: configure()..");
        print("+----------------------------------------+");
        http.csrf().disable()      //关闭 csrf [同源策略]
         //不通过 session 获取 SecurityContext[不使用session]
        .sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS )
        .and()
        .authorizeRequests()  //对于登录接口允许匿名访问

        .antMatchers("/hello1").permitAll()//所有人都可以访问
        .antMatchers("/Common/login").anonymous()
        .antMatchers("/Common/getRouteList").anonymous()
        //需要登录、权限认证
//        .antMatchers("/*/*").anonymous();
//
//
        .antMatchers("/dept/edit").hasAuthority("dept:edit")
        .antMatchers("/dept/view").hasAuthority("dept:view")
//        .anyRequest().anonymous();
         //[.permitAll()]

         //除上面外的所有请求全部需要鉴权认证
        .anyRequest().authenticated();

        //{3}添加过滤器
        http.addFilterBefore( jwtAuthTokenFilter,
            UsernamePasswordAuthenticationFilter.class );

        //{4}异常处理器 {authcEntryPoint}
        http.exceptionHandling()
           .authenticationEntryPoint( authcEntryPoint )
           .accessDeniedHandler( accessDeniedHandler );
    }

    void print(Object obj){
        System.out.println("Security:"+ obj);
    }
}
