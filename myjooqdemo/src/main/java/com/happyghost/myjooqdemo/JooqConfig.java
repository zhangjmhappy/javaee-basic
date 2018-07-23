package com.happyghost.myjooqdemo;

import com.alibaba.druid.pool.DruidDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class JooqConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dslContext")
    public DSLContext getDSLContext() {
        // 配置DruidDataSource
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        // 配置JOOQ
        ConnectionProvider connectionProvider = new DataSourceConnectionProvider(druidDataSource);
        org.jooq.Configuration configuration = new DefaultConfiguration();
        configuration.set(connectionProvider).set(SQLDialect.MYSQL);
        // 领域对象编程
        return DSL.using(configuration);


    }
}