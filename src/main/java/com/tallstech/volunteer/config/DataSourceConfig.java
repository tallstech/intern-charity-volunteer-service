package com.tallstech.volunteer.config;

import javax.sql.DataSource;


import com.tallstech.volunteer.constant.VolunteerConstants;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Getter
@Configuration
public class DataSourceConfig {
    @Bean(name = VolunteerConstants.VOLUNTEER_DATA_SOURCE)
    @ConfigurationProperties(prefix = "cvs.datasource.volunteer")
    public DataSource createMetadataDataSource() {
        return  DataSourceBuilder.create()
                .build();
    }

    @Bean(name = VolunteerConstants.VOLUNTEER_JDBC_TEMPLATE)
    @Primary
    public JdbcTemplate createVolunteerJdbcTemplate(@Qualifier(VolunteerConstants.VOLUNTEER_DATA_SOURCE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
