package top.krasus1966.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.krasus1966.shop.interceptor.NotFountInterceptor;

/**
 * 拦截器配置
 *
 * @author Krasus1966
 * @date 2020/8/8 21:55
 **/
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NotFountInterceptor()).addPathPatterns("/**");
    }
}
