package com.sapiens.mdval;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.sapiens.mdval.config.OracleDataSourceConfig;

@SpringBootTest
@ContextConfiguration(classes = {OracleDataSourceConfig.class})
class MDValApplicationTests {

	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}

}
