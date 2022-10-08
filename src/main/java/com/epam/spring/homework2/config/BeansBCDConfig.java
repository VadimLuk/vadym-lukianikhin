package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:beans.properties")

public class BeansBCDConfig {
    @Bean(name = "beanD", initMethod = "init", destroyMethod = "destroy")
    public BeanD BeanD() {
        return new BeanD("Tom", 54);
    }

    @Bean(name = "beanB", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB BeanB() {
        return new BeanB("Bill", 11);
    }

    @Bean(name = "beanC", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC BeanC() {
        return new BeanC("Mark", 30);
    }

}
