package com.cooldatasoft.rest.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by fmucar on 25/09/15.
 */
@Slf4j
@WebListener
public class MyListener implements ServletContextListener {

    private SpringContextLoaderListener springContextLoaderListener = new SpringContextLoaderListener();
    private ResteasyBootstrap resteasyBootstrap = new ResteasyBootstrap();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        servletContextEvent.getServletContext().setInitParameter("resteasy.servlet.mapping.prefix","/v1");
//        servletContextEvent.getServletContext().setInitParameter("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
//        servletContextEvent.getServletContext().setInitParameter("contextConfigLocation","com.cooldatasoft.rest.config.AppConfig");

        log.info("contextInitialized");
        resteasyBootstrap.contextInitialized(servletContextEvent);
        springContextLoaderListener.contextInitialized(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("contextDestroyed");
        resteasyBootstrap.contextDestroyed(servletContextEvent);
        springContextLoaderListener.contextInitialized(servletContextEvent);
    }
}
