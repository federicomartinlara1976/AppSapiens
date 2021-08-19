package com.sapiens.app;

import com.sapiens.app.config.OracleDataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@SpringBootTest
@ContextConfiguration(classes = {OracleDataSourceConfig.class})
class MDValApplicationTests {

	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

}
