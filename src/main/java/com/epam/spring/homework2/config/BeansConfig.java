package com.epam.spring.homework2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages ={"com.epam.spring.homework2.beans","com.epam.spring.homework2.beanpostprocessor"} )
@Import(OtherBeansConfig.class)
public class BeansConfig {
}
