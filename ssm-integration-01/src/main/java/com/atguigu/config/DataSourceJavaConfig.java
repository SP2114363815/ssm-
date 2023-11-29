package com.atguigu.config;
import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;
import javax.sql.DataSource;

//连接池配置类
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceJavaConfig {
   @Value("${jdbc.user}")
    private String user;

   @Value("${jdbc.password}")
   private String password;

   @Value("${jdbc.url}")
   private String url;

   @Value("${jdbc.driver}")
   private String driver;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
