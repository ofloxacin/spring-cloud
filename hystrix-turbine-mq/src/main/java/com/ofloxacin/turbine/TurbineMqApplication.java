package com.ofloxacin.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author chens
 **/
@EnableTurbineStream
@SpringBootApplication
public class TurbineMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineMqApplication.class, args);
    }
}
