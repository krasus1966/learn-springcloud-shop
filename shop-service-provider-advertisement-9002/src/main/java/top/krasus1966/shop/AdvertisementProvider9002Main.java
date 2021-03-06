package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krasus1966
 * @date 2020/8/6 21:47
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AdvertisementProvider9002Main {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisementProvider9002Main.class,args);
    }
}
