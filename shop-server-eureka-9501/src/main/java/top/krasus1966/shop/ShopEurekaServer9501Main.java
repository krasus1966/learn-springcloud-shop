package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Krasus1966
 * @date 2020/7/19 11:09
 **/
@SpringBootApplication
@EnableEurekaServer
public class ShopEurekaServer9501Main {
    public static void main(String[] args) {
        SpringApplication.run(ShopEurekaServer9501Main.class,args);
    }
}
