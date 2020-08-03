package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务提供模块启动类（目前仅有品牌服务）
 * @author Krasus1966
 * @date 2020/7/17 22:16
 **/
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient //使用Nacos时使用此注解
public class ShopProvider9001Main {

    public static void main(String[] args) {
        SpringApplication.run(ShopProvider9001Main.class, args);
    }

}
