package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 持久层配置类
 * \
 *
 * sqlSessionFactiry
 * Mapper代理对象
 *
 *
 *
 * 如果将dataSource和mybatis的组件配置到一起，出发@Value注解不生效的问题
 * 原因：mybatis的组件优先加载，@Value还没有读取
 * 解决：分开配置，写到不同的类即可
 */
@Configuration
public class MapperJavaConfig {

    //sqlSessionFactory加入到ioc容器
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //指定配置文件等信息
        //指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定外部的mybatis配置文件
        Resource resource=new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    //mapper代理对象加入到ioc
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.atguigu.mapper");//mapper和mapper.xml所在的共同的包
        return mapperScannerConfigurer;
    }
}
