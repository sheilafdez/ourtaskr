package net.javaloping.ourtaskr.test.context;

import net.javaloping.ourtaskr.business.context.PersistenceConfig;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author victormiranda
 */

@Configuration
@EnableTransactionManagement
public class PersistenceTestConfig extends PersistenceConfig {

	@Bean
	public DataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/hibernate_tests");
		dataSource.setUsername("root");
		dataSource.setPassword("paco");

		return dataSource;
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", "create" );
				setProperty("hibernate.dialect",
					"org.hibernate.dialect.MySQLDialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
				setProperty("hibernate.hbm2ddl.import_files","import.sql");
				setProperty("hibernate.hbm2ddl.import_files_sql_extractor",
					"org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor");
			}
		};
	}
}