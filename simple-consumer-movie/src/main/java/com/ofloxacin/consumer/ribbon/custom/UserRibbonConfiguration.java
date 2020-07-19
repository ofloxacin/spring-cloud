package com.ofloxacin.consumer.ribbon.custom;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @author chens
 **/
public class UserRibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
