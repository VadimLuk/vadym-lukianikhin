package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.annotations.MyCustomBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@MyCustomBean
@Lazy
public class BeanF {
    private String name;
    private int value;

    public BeanF(@Value("Tony") String name, @Value("40") int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
