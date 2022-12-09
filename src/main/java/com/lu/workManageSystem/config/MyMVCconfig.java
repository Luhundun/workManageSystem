package com.lu.workManageSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @ClassName: MyMVCconfig
 * @Description:
 * @Author: luning
 * @Date: 2021/10/21 14:42
 * @Version: v1.0
 */

//diy定制化的功能 只需要写这个组件，然后交给springboot自动装配
    //拓展springmvc
@Configuration
public class MyMVCconfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }



    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }



//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/login").setViewName("login");
////        registry.addViewController("/main").setViewName("index");
//    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","/teacherLogin","/studentLogin","/css/**","/js/**","/img/**");
    }


//    @Bean(name="mutipartResolver")
//    public CommonsMultipartResolver mutipartResolver(){
//        return new CommonsMultipartResolver();
//    }
}
