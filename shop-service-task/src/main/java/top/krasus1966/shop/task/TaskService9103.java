package top.krasus1966.shop.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Krasus1966
 * @date 2020/9/15 11:59
 **/
@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class TaskService9103 {
    public static void main(String[] args) {
        SpringApplication.run(TaskService9103.class,args);
    }
}
