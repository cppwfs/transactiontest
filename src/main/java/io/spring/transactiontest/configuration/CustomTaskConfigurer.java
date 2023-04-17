package io.spring.transactiontest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomTaskConfigurer extends DefaultTaskConfigurer {

    @Autowired
    public CustomTaskConfigurer(@Qualifier("scdfDataSource") DataSource dataSource) {
        super(dataSource);
    }
}
