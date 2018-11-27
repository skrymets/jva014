/*
 * Copyright 2018 skrymets.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.luxoft.training.jva014;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SequenceGenerator;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.luxoft.training.jva014.repositories"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
//@EntityScan(basePackages = {"com.luxoft.jva014.model"})
@EnableTransactionManagement
@SequenceGenerator("JVA014_681d0980f383");
// @org.springframework.context.annotation.PropertySource("classpath:application.properties")
public class JPAConfig {

    public static final String SEQUENCE_GEN_NAME = "JVA014_681d0980f383"
    
    //@Resource
    //private Environment env;
//    @Bean
//    LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        factoryBean.setPersistenceUnitName("com.luxoft_jva014");
//        return factoryBean;
//    }
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // factoryBean.setPackagesToScan("com.luxoft.jva014.model");
        factoryBean.setPersistenceUnitName("com.luxoft_jva014");
        return factoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory,
            DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource(Environment env) {
        HikariConfig dsConfig = new HikariConfig();
        
        dsConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
        dsConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
        dsConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
        dsConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));
        
        return new HikariDataSource(dsConfig);
    }

}
