/*
package com.cookbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

*/
/**
 * 配置跨域配置
 *//*

@Configuration
public class CorsConfig {

    // 将当前方法注册为bean对象
    @Bean
    public CorsFilter corsFilter(){
        // 跨域请求配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域请求携带验证信息
        corsConfiguration.setAllowCredentials(true);
        // 允许的域名
         //corsConfiguration.addAllowedOrigin("http://localhost:8088/");
        // corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8080","http://localhost:8088"));
        // 允许的请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许请求方式
        corsConfiguration.addAllowedMethod("POST");

        // 基于请求路径的跨域配置
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // 注册跨域配置
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
*/
