package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {
    private String name;
    private int value;

    public BeanE(@Value("Edward") String name, @Value("19") int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(getClass().getSimpleName() + " @PreDestroy method");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(getClass().getSimpleName() + " @PostConstruct method");
    }
}
