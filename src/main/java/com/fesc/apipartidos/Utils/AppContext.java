package com.fesc.apipartidos.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class AppContext implements ApplicationContextAware{

    private static ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        
        context = applicationContext;
    }

    public static Object getBean(String name) {

        return context.getBean(name);
    }
}