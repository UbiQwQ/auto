package com.innovation.auto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: carver
 * @Date: 2019/1/3 21:57
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS)
                .maxAge(3600);
    }
}
