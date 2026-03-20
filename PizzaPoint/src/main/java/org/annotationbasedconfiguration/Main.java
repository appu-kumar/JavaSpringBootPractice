package org.annotationbasedconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // This line of code load applicationContext.xml and create ioc container and gives the ref of ioc container
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(container);
    }
}