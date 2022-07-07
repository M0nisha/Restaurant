package org.example.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {

    @Autowired
    public Interceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new Interceptor())
                .excludePathPatterns(  "/login" , "/signup") . pathMatcher(new AntPathMatcher());
    }
}


