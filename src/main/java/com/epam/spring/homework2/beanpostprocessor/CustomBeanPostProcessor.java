package com.epam.spring.homework2.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;


@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\nStarted validating :" + beanName);
        if (validateNameField(bean) && validateValueField(bean)){
            System.out.println(beanName + " is Valid");
            return bean;
        } else {
            throw new RuntimeException(beanName + "is Invalid");
        }
    }

    private boolean validateNameField(Object bean) {
        String name;
        try {
            Field field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(bean);
        } catch (NoSuchFieldException e) {
            return true;
        } catch (IllegalAccessException e) {
            return true;
        }
        return Objects.nonNull(name);
    }

    private boolean validateValueField(Object bean) {
        int value;
        try {
            Field field = bean.getClass().getDeclaredField("value");
            field.setAccessible(true);
            value = (int) field.get(bean);
        } catch (NoSuchFieldException e) {
            return true;
        } catch (IllegalAccessException e) {
            return true;
        }
        return value > 0;
    }

}
