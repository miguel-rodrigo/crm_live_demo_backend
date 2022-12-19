package com.bootcamp4.CRMLiveDemo.config;

//import com.bootcamp4.CRMLiveDemo.auth.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**/deal/**");
//    }
}
