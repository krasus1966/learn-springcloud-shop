package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Krasus1966
 * @date 2020/7/16 22:33
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableSwagger2
public class ShopConsumer80Main {
    public static void main(String[] args) {
        SpringApplication.run(ShopConsumer80Main.class, args);
    }
}
