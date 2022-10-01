package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
    private String name;
    private int value;

    public BeanB(@Value("${beanB.name}") String name, @Value("${beanB.value}") int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


    public void init() {
        System.out.println(getClass().getSimpleName() + " @Bean:initMethod -> init");
    }

    public void customInit(){
        System.out.println(getClass().getSimpleName() + " @Bean:initMethod -> customInit");
    }

    public void destroy() {
        System.out.println(getClass().getSimpleName() + " @Bean:destroyMethod");
    }
}
