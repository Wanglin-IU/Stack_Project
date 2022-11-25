package com.example.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置
        //a页面想获取b页面资源
        //如果a、b页面的协议、域名、端口、子域名不同,所进行的访问行动都是跨域的
        //而浏览器为了安全问题一般都限制了跨域访问,也就是不允许跨域请求资源。
        //注意:跨域限制访问,其实是浏览器的限制.理解这一点很重要！！！
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
