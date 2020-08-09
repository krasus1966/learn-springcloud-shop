package top.krasus1966.shop;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krasus1966
 * @date 2020/8/9 21:53
 **/
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class ActuatorAdmin9102Main {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorAdmin9102Main.class,args);
    }
}
