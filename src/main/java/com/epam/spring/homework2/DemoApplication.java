package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.config.BeansConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        System.out.println(context.getBean("beanB", BeanB.class));
        System.out.println(context.getBean("beanC", BeanC.class));
        System.out.println(context.getBean("beanD", BeanD.class));

    }
}
