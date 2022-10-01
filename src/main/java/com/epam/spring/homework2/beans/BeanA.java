package com.epam.spring.homework2.beans;

public class BeanA {
    private String name;
    private String value;

    public BeanA(String name, String value) {
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
}
