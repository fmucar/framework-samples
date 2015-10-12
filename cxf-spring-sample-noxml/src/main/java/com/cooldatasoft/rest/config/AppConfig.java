package com.cooldatasoft.rest.config;

import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.*;

/**
 * Spring configuration via annotations
 * @author Fatih
 *
 */

//<import resource="classpath:META-INF/cxf/cxf.xml"/>
//        <import resource="classpath:META-INF/cxf/cxf-extension-xml.xml"/>
//        <import resource="classpath:META-INF/cxf/cxf-servlet.xml"/>


@Configuration
@ComponentScan("com.cooldatasoft.rest")
@PropertySource("classpath:application.properties")
//@ImportResource({"classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-extension-xml.xml", "classpath:META-INF/cxf/cxf-servlet.xml"})
public class AppConfig {

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
        }


//            25.@Bean
//    26.public Server jaxRsServer() {
//        27.JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint( jaxRsApiApplication(), JAXRSServerFactoryBean.class );
//        28.factory.setServiceBeans( Arrays.< Object >asList( peopleRestService() ) );
//        29.factory.setAddress( "/" + factory.getAddress() );
//        30.factory.setProviders( Arrays.< Object >asList( jsonProvider() ) );
//        31.return factory.create();
//        32.}
//    33.
//            34.@Bean
//    35.public JaxRsApiApplication jaxRsApiApplication() {
//        36.return new JaxRsApiApplication();
//        37.}
//    38.
//            39.@Bean
//    40.public PeopleRestService peopleRestService() {
//        41.return new PeopleRestService();
//        42.}
//    43.
//            44.@Bean
//    45.public PeopleService peopleService() {
//        46.return new PeopleService();
//        47.}
//    48.
//            49.@Bean
//    50.public JacksonJsonProvider jsonProvider() {
//        51.return new JacksonJsonProvider();
//        52.}

}
