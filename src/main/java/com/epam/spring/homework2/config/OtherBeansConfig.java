package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:beans.properties")

public class OtherBeansConfig {
    @Bean(name = "beanD", initMethod = "init", destroyMethod = "destroy")
    public BeanD BeanD(@Value("${beanD.name}") String name, @Value("${beanD.value}") int value) {
        return new BeanD(name, value);
    }

    @Bean(name = "beanB", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB BeanB(@Value("${beanB.name}") String name, @Value("${beanB.value}") int value) {
        return new BeanB(name, value);
    }

    @Bean(name = "beanC", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC BeanC(@Value("${beanC.name}") String name, @Value("${beanC.value}") int value) {
        return new BeanC(name, value);
    }

}
