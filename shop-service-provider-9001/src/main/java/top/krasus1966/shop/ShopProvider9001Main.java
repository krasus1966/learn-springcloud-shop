package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
//@EnableSwagger2
@EnableDiscoveryClient //使用Nacos时使用此注解
public class ShopProvider9001Main {

    public static void main(String[] args) {
        SpringApplication.run(ShopProvider9001Main.class, args);
    }

}
