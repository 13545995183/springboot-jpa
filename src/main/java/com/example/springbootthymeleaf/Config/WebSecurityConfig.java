package com.example.springbootthymeleaf.Config;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.context.annotation.Configuration;

/*Security配置类*/
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*    protected void config(HttpSecurity httpSecurity)throws Exception{
        //配置所有请求都可以访问
        //httpSecurity.authorizeRequests().anyRequest().permitAll();
        //允许客户端通过iframe访问
        //httpSecurity.headers().frameOptions().sameOrigin();
        //可以通过and进行连接
        httpSecurity.authorizeRequests().anyRequest().permitAll().and().headers().frameOptions().sameOrigin();
    }*/
/*    protected void config(WebSecurity security){
        //释放静态资源
        security.ignoring().antMatchers("/css/**","/js/**","/templates/**");
    }*/
    /*protected void configure(HttpSecurity security)throws Exception{
        //配置认证
        security.formLogin()
                //登陆页面路径配置
                .loginPage("/login")
                //登陆处理路径配置
                .loginProcessingUrl("doLogin")
                //登陆成功之后页面配置
                .defaultSuccessUrl("/")
                //登陆失败页面配置
                .failureUrl("/loginError")
                //配置以上路径，可以在非登陆下访问
                .permitAll()
                //连接符
                .and()
                //注销配置
                .logout().permitAll()
                .and()
                //配置授权
                .authorizeRequests()
                //所有请求
                .anyRequest()
                //经过验证
                .authenticated()
                //允许客户端iframe访问
                .and().headers().frameOptions().sameOrigin()
                //取消组织跨站请求伪造，否则造成开发不便利
                .and().csrf().disable();
    }*/
    //配置明文账户密码
/*    protected void config(AuthenticationManagerBuilder auth)throws  Exception{
        auth.inMemoryAuthentication()
                .passwordEncoder(UEncoder)
                .withUser("aaa").password("111")
                .and()
                .withUser("bbb").password("111");
    }*/
//}
