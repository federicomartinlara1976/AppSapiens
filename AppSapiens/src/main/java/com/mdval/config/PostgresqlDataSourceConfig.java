package com.mdval.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import com.mdval.utils.ConfigurationSingleton;

import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Configuration
@Log4j
public class PostgresqlDataSourceConfig {

    /**
     * PostgreSQL Datasource configuration
     *
     * @return the data source connection
     */
    @SuppressWarnings("rawtypes")
	//@Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = null;
        try {
            ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
            dataSourceBuilder = DataSourceBuilder.create();

            dataSourceBuilder.driverClassName(configuration.getConfig("postgresql.driverClassName"));
            dataSourceBuilder.username(configuration.getConfig("postgresql.username"));
            dataSourceBuilder.password(configuration.getConfig("postgresql.password"));
            dataSourceBuilder.url(configuration.getConfig("postgresql.url"));

        } catch (IOException ea) {
            log.error("Error connecting to the postgresql database: " + ea.getMessage());
        }

        return dataSourceBuilder.build();
    }
}
