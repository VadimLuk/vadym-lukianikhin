package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.annotations.MyCustomBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@MyCustomBean
public class BeanA implements InitializingBean, DisposableBean {
    private String name;
    private int value;

    public BeanA(@Value("Andrii") String name,@Value("8") int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(getClass().getSimpleName() + " DisposableBean:destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + " InitializingBean:afterPropertiesSet");
    }
}
