//package top.krasus1966.shop.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
///**
// * @author Krasus1966
// * @date 2020/7/21 20:49
// **/
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket swaggerDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .build().pathMapping("/")
//                .apiInfo(new ApiInfoBuilder()
//                        .title("基于SpringCloud的商城系统-服务端")
//                        .description("使用SpringCloud框架开发的微服务商城-服务端")
//                        .build());
//    }
//}
