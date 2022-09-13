/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.uav.formatter.BusesFormatter;
import com.uav.formatter.PlxeFormatter;
import com.uav.formatter.ProviceFormatter;
import com.uav.formatter.RouteFormatter;
import com.uav.formatter.TramFormatter;
import com.uav.formatter.UserFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author pc
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.uav.controllers",
    "com.uav.repository",
    "com.uav.service",
    "com.uav.validator"
})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }

    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/resources/images/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");

        return m;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());

        return v;
    }

    @Override
    public void addFormatters(FormatterRegistry r) {
        r.addFormatter(new RouteFormatter());
        r.addFormatter(new PlxeFormatter());
        r.addFormatter(new UserFormatter());
        r.addFormatter(new BusesFormatter());
        r.addFormatter(new ProviceFormatter());
        r.addFormatter(new TramFormatter());
    }
    
    
    // upload file anh len coudinary
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dscxdufdh",
                "api_key", "543967497156936",
                "api_secret", "L1oCI0MVosglFGR_XygVYdEaXYU",
                "secure", true));
        return cloudinary;
    }

    // end  
}
