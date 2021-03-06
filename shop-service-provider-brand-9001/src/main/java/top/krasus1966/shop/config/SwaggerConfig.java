package top.krasus1966.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2 配置类
 * @author Krasus1966
 * @date 2020/7/21 20:49
 **/
@EnableOpenApi
@Profile({"dev-nacos","test"})
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build().pathMapping("/")
                .apiInfo(new ApiInfoBuilder()
                        .title("基于SpringCloud的商城系统-服务端-品牌服务")
                        .description("使用SpringCloud框架开发的微服务商城-服务端-品牌服务")
                        .version("0.0.1-SNAPSHOT")
                        .build());
    }
}
