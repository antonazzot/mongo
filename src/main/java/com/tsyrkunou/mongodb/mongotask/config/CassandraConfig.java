package com.tsyrkunou.mongodb.mongotask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraCqlTemplateFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "testKeySpace";
    }


    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}