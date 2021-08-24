package com.mdval.config;

import com.mdval.utils.ConfigurationSingleton;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hcarreno
 */
@Configuration
@Log4j
public class OracleDataSourceConfig {

    /**
     * Datasource configuration
     *
     * @return the pool data source connection
     */
    @Bean
    public DataSource dataSource() {

        PoolDataSource poolDataSource = null;
        try {
            ConfigurationSingleton configuration = ConfigurationSingleton.getInstance();
            poolDataSource = PoolDataSourceFactory.getPoolDataSource();

            poolDataSource.setConnectionFactoryClassName(configuration.getConfig("dataSource.driverClassName"));
            poolDataSource.setURL(configuration.getConfig("dataSource.url"));
            poolDataSource.setUser(configuration.getConfig("dataSource.username"));
            poolDataSource.setPassword(configuration.getConfig("dataSource.password"));
            poolDataSource.setMinPoolSize(Integer.parseInt(configuration.getConfig("dataSource.minPoolSize")));
            poolDataSource.setInitialPoolSize(Integer.parseInt(configuration.getConfig("dataSource.initialPoolSize")));
            poolDataSource.setMaxPoolSize(Integer.parseInt(configuration.getConfig("dataSource.maxPoolSize")));

        } catch (SQLException | IOException ea) {
            log.error("Error connecting to the database: " + ea.getMessage());
        }

        return poolDataSource;
    }
}
