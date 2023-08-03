package com.fastcampus.minischeduler.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // 1. 절대경로 file:///c:/upload/
        // 2. 상대경로 file:./upload/
        registry
                .addResourceHandler("/upload/**")
                .addResourceLocations("file:" + "./upload/")
                .setCachePeriod(60 * 60) // 초 단위 => 한시간
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(adminInterceptor)
//                .addPathPatterns("/admin/**");
//
//        registry.addInterceptor(sellerInterceptor)
//                .addPathPatterns("/seller/**");
    }


    // CORS, Interceptor, Resource, addArgumentResolvers, viewResolver, MessageConverter
}