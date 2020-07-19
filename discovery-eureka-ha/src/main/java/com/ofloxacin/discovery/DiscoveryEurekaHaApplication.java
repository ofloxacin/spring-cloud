package com.ofloxacin.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenshuai
 * @date 2020/07/18
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryEurekaHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaHaApplication.class, args);
    }
}
