package com.cookbook.security;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: dxy
 * @time: 2020/8/26 17:53
 */
@Component
public class MyConfiguration implements WebMvcConfigurer {

    /*
    虚拟路径配置
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Release/**").addResourceLocations("file:/D:/Vue_space/backstage_vue/src/img/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /*
    * cookie存储方式
    * */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory) -> factory.addContextCustomizers(
                (context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
    }


}
