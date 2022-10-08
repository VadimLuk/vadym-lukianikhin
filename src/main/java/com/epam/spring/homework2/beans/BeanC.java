package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.annotations.MyCustomBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@MyCustomBean
public class BeanC {
    private String name;
    private int value;

    public BeanC(@Value("${beanC.name}") String name, @Value("${beanC.value}") int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void init() {
        System.out.println(getClass().getSimpleName() + " @Bean:initMethod");
    }

    public void destroy() {
        System.out.println(getClass().getSimpleName() + " @Bean:destroyMethod");
    }
}
