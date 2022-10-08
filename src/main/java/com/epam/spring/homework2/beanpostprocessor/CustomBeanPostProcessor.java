package com.epam.spring.homework2.beanpostprocessor;

import com.epam.spring.homework2.beans.annotations.MyCustomBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;


@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(MyCustomBean.class)) {
            System.out.println("\nStarted validating :" + beanName);
            if (validateNameField(bean) && validateValueField(bean)) {
                System.out.println(beanName + " is Valid");
                return bean;
            } else {
                throw new RuntimeException(beanName + "is Invalid");
            }
        }
        return bean;
    }

    private boolean validateNameField(Object bean) {
        try {
            Field field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(bean);
            return Objects.nonNull(name);
        } catch (NoSuchFieldException e) {
            return true;
        } catch (IllegalAccessException e) {
            return true;
        }
    }

    private boolean validateValueField(Object bean) {
        try {
            Field field = bean.getClass().getDeclaredField("value");
            field.setAccessible(true);
            int value = (int) field.get(bean);
            return value > 0;
        } catch (NoSuchFieldException e) {
            return true;
        } catch (IllegalAccessException e) {
            return true;
        }
    }

}
