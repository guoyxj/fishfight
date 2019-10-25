package com.fishfight.common.config;

import com.fishfight.Interceptor.SysUserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;

/**
 * MVC 配置
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    /**
     * 配置静态资源路由
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录校验拦截
        List<String> unInterceptorPath = Arrays.asList("/login","/login/**","/","/static/**");
        registry.addInterceptor(new SysUserLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(unInterceptorPath);
    }
}
