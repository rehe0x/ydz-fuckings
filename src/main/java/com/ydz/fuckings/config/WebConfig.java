package com.ydz.fuckings.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ydz.fuckings.common.ActionInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	 registry.addResourceHandler("/webapp/**").addResourceLocations("classpath:/templates/");
    	 registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/templates/admin/");
    //	 registry.addResourceHandler("/apps/**").addResourceLocations("classpath:/templates/apps/");
    }
    
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController( "/" ).setViewName( "forward:/index.html" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers(registry );
    }
    
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ActionInterceptor())
        .addPathPatterns("/sysuser/getSessionUser")
        .excludePathPatterns("admin/login","admin/assets/","admin/js/","admin/css/","/apps/");
        super.addInterceptors(registry);//对来自//** 这个链接来的请求进行拦截
    }

}
