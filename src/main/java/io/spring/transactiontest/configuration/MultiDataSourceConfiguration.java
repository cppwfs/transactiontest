package io.spring.transactiontest.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
public class MultiDataSourceConfiguration {

    @Bean(name = "springDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    @Primary
    public DataSourceProperties springDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "scdfDataSourceProperties")
    @ConfigurationProperties("scdf.datasource")
    public DataSourceProperties scdfDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "springDataSource")
    @Primary
    public DataSource dataSource(@Qualifier("springDataSourceProperties") DataSourceProperties springDataSourceProperties) {
        return DataSourceBuilder.create()
                .driverClassName(springDataSourceProperties.getDriverClassName())
                .url(springDataSourceProperties.getUrl())
                .password(springDataSourceProperties.getPassword())
                .username(springDataSourceProperties.getUsername())
                .build();
    }

    @Bean(name = "scdfDataSource")
    public DataSource scdfDataSource(@Qualifier("scdfDataSourceProperties") DataSourceProperties scdfDataSourceProperties) {
        return DataSourceBuilder.create()
                .driverClassName(scdfDataSourceProperties.getDriverClassName())
                .url(scdfDataSourceProperties.getUrl())
                .password(scdfDataSourceProperties.getPassword())
                .username(scdfDataSourceProperties.getUsername())
                .build();
    }
}
