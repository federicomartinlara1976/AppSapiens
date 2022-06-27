package com.mdval;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.mdsql.config.OracleDataSourceConfig;
import com.mdsql.utils.LiteralesSingleton;

@SpringBootTest
@ContextConfiguration(classes = {OracleDataSourceConfig.class})
class MDSQLApplicationTests {

	@MockBean
	private DataSource dataSource;

	@Test
	void contextLoads() {
		try {
			LiteralesSingleton literales = LiteralesSingleton.getInstance();
			assertNotEquals(StringUtils.EMPTY, literales.getLiteral("menu.configuracion"));
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
