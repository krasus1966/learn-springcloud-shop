package top.krasus1966.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 管理端启动类
 * @author Krasus1966
 * @date 2020/7/22 21:34
 **/
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class AdminProvider9101Main{
    public static void main(String[] args) {
        SpringApplication.run(AdminProvider9101Main.class,args);
    }
}
