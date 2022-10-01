package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
    private String name;
    private String value;

    public BeanB(@Value("${beanB.name}") String name, @Value("${beanB.value}") String value) {
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
}
