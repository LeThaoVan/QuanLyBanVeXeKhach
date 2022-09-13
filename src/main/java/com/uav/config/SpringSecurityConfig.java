/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.uav.config.handlers.LoginSuccessHandler;
import com.uav.config.handlers.MyLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.uav.repository",
    "com.uav.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    
    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;
    
    @Bean
    public Cloudinary cloudinary() {
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "dscxdufdh",
        "api_key", "543967497156936",
        "api_secret", "L1oCI0MVosglFGR_XygVYdEaXYU",
        "secure", true));
        return cloudinary;
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler()
    {
        return new LoginSuccessHandler();
    }
    
    @Bean 
    public LogoutSuccessHandler myLogoutSuccessHandler(){
        return  new MyLogoutSuccessHandler();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
           http.formLogin().loginPage("/login")
                   .usernameParameter("username")
                   .passwordParameter("password"); // trường name usename 
                                                    //và password trong form login
                                                    
          http.formLogin().defaultSuccessUrl("/") //nếu login thành công thì nó sẽ đi theo url này
                          .failureUrl("/login?error"); //nếu login thất bại
          http.formLogin().successHandler(this.loginSuccessHandler);
          
          http.logout().logoutSuccessUrl("/login");
          http.logout().logoutSuccessHandler(this.myLogoutSuccessHandler);
          
          http.exceptionHandling().accessDeniedPage("/login?accessDenied");
          
          http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/admin/**")
                                .access("hasRole('ROLE_ADMIN')")
                                ;
          
          
          http.csrf().disable(); //bật lên khi hạn chế người dùng chèn
          // một số mã đọc vào form
                                                    
    }
}
