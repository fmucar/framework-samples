package com.cooldatasoft.config;

import org.springframework.cassandra.config.java.AbstractSessionConfiguration;
import org.springframework.cassandra.core.CqlOperations;
import org.springframework.cassandra.core.CqlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import javax.annotation.Resource;

@Configuration
@ComponentScan({"com.cooldatasoft"})
@EnableCassandraRepositories(basePackages = {"com.cooldatasoft.repository"})
public class AppConfig extends AbstractSessionConfiguration {

    @Resource
    private Environment env;

    @Override
    protected String getKeyspaceName() {
        return "cooldatasoft";
    }

    @Bean
    public CqlOperations cqlTemplate() throws Exception {
        return new CqlTemplate(session().getObject());
    }


    @Bean
    public CqlOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

}
