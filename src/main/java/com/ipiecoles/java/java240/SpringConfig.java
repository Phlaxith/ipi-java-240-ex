package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.ipiecoles.java.java240")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Value("${bitcoinService.forceRefresh}")
    public Boolean forceRefresh;

    @Bean(name = "bitcoinServiceCacheProperty")
    public BitcoinService bitcoinServiceCacheProperty() {
        System.out.println("Instantiation du bean BitcoinService sans cache par Spring");
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
        return bitcoinService;
    }

}
