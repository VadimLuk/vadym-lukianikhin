package com.epam.spring.homework2;


import com.epam.spring.homework2.beanfactorypostprocessor.CustomBeanFactoryPostProcessor;
import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.config.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        CustomBeanFactoryPostProcessor processor = new CustomBeanFactoryPostProcessor();

        context.register(BeansConfig.class);
        context.addBeanFactoryPostProcessor(processor);
        context.refresh();


        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(
                        bean->System.out.println(context.getBeanDefinition(bean)));


        context.registerShutdownHook();
    }
}
