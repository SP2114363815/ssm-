package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * controller
 * 全局异常处理
 * handlerMapping  handlerAdapter
 * 静态资源处理
 * jsp视图解析器前后缀
 * json转换器
 * 拦截器
 *
 *
 */
@Configuration
@ComponentScan({"com.atguigu.controller","com.atguigu"})
//@ComponentScan({"com.atguigu.controller","com.atguigu.exceptionhandler"})
@EnableWebMvc
public class WebMvcJavaConfig implements WebMvcConfigurer {


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/","jsp");
    }
    //拦截器

   // @Override
    //public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new xx()).addPathPatterns().excludePathPatterns();
    //}
}
