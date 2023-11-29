package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIOCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//root容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, MapperJavaConfigNew.class, ServiceJavaConfig.class};
    }
//web容器的配置类指定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }
//dispatcherServlect的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
