package com.ofloxacin.consumer.ribbon;

import com.ofloxacin.consumer.ribbon.custom.DefaultRibbonConfiguration;
import com.ofloxacin.consumer.ribbon.custom.UserRibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author chens
 **/
@RibbonClients(value = {
        @RibbonClient(value = "provider-user", configuration = UserRibbonConfiguration.class)
}, defaultConfiguration = DefaultRibbonConfiguration.class)
public class RibbonConfiguration {

}
