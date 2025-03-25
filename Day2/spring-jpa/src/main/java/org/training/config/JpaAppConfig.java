package org.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.training")
public class JpaAppConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/libraryDb");
        ds.setUsername("root");
        ds.setPassword("P@ssword");

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcb = new LocalContainerEntityManagerFactoryBean();
        lcb.setDataSource(dataSource());
        lcb.setPackagesToScan("org.training.dao");

        HibernateJpaVendorAdapter hva = new HibernateJpaVendorAdapter();
        hva.setDatabase(Database.MYSQL);
        hva.setShowSql(true);

        lcb.setJpaVendorAdapter(hva);

        return lcb;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return tx;
    }
}
