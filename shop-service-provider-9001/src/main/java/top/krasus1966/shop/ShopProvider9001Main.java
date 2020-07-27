package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2
public class ShopProvider9001Main {

    public static void main(String[] args) {
        SpringApplication.run(ShopProvider9001Main.class, args);
    }

}
