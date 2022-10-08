package com.epam.spring.homework2.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


//    Створити окремий бін, що реалізовує BeanFactoryPostProcessor.
//    За допомогою нього для біна BeanB змінити параметр initMethod на значення іншого користувацького методу.
//    Передбачити вивід відповідних повідомлень.

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor is Working");
        System.out.println("Previous BeanB init method: " +configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName());

        configurableListableBeanFactory.getBeanDefinition("beanB").setInitMethodName("customInit");

        System.out.println("New BeanB init method: " + configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName());
        System.out.println("BeanFactoryPostProcessor ended his work");
    }
}
