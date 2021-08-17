package com.hlx.posterm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

@ComponentScan
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        ApplicationContext ctxt = new AnnotationConfigApplicationContext(Application.class);
        LOG.info("Started up!");
        ((AbstractApplicationContext)ctxt).close();
    }

}
