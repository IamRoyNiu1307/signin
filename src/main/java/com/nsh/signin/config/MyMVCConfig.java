package com.nsh.signin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.nsh.signin.handlerInterceptor.LoginHandlerInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    //视图控制
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("/index");
                registry.addViewController("/main").setViewName("/dashboard");
                registry.addViewController("/checkin").setViewName("/checkin");
                registry.addViewController("/myCourse").setViewName("/myCourse");
                registry.addViewController("/myStudent").setViewName("/myStudent");
            }
        };
        return webMvcConfigurer;
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        //静态资源；  *.css , *.js
        //SpringBoot已经做好了静态资源映射
        List<String> excludePathPatternsList = new ArrayList<>();
        excludePathPatternsList.add("/");
        excludePathPatternsList.add("/static/**");
        excludePathPatternsList.add("/teacher/login");
        excludePathPatternsList.add("/wx/**");
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludePathPatternsList);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/fileUpload/**").addResourceLocations("file:/Users/roy/project/signin/src/main/resources/static/fileUpload/");
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }



}
