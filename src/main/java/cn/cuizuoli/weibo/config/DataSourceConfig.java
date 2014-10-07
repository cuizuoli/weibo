/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.cuizuoli.weibo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * DataSource Configuration.
 * @author cuizuoli
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class DataSourceConfig implements TransactionManagementConfigurer {

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("weibo.jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("weibo.jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("weibo.jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("weibo.jdbc.password"));
		dataSource.setInitialSize(env.getRequiredProperty("jdbc.initialSize", Integer.class));
		dataSource.setMaxActive(env.getRequiredProperty("jdbc.maxActive", Integer.class));
		dataSource.setMaxIdle(env.getRequiredProperty("jdbc.maxIdle", Integer.class));
		dataSource.setMinIdle(env.getRequiredProperty("jdbc.minIdle", Integer.class));
		dataSource.setDefaultAutoCommit(env.getRequiredProperty("jdbc.defaultAutoCommit", Boolean.class));
		dataSource.setPoolPreparedStatements(env.getRequiredProperty("jdbc.poolPreparedStatements", Boolean.class));
		dataSource.setValidationQuery(env.getRequiredProperty("jdbc.validationQuery"));
		dataSource.setTestOnBorrow(env.getRequiredProperty("jdbc.testOnBorrow", Boolean.class));
		dataSource.setTestOnReturn(env.getRequiredProperty("jdbc.testOnReturn", Boolean.class));
		dataSource.setTestWhileIdle(env.getRequiredProperty("jdbc.testWhileIdle", Boolean.class));
		dataSource.setTimeBetweenEvictionRunsMillis(env.getRequiredProperty("jdbc.timeBetweenEvictionRunsMillis", Long.class));
		dataSource.setNumTestsPerEvictionRun(env.getRequiredProperty("jdbc.numTestsPerEvictionRun", Integer.class));
		dataSource.setMinEvictableIdleTimeMillis(env.getRequiredProperty("jdbc.minEvictableIdleTimeMillis", Long.class));
		return dataSource;
	}

	@Bean
	public DataSource slaveDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("weibo.slave.jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("weibo.slave.jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("weibo.slave.jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("weibo.slave.jdbc.password"));
		dataSource.setInitialSize(env.getRequiredProperty("jdbc.initialSize", Integer.class));
		dataSource.setMaxActive(env.getRequiredProperty("jdbc.maxActive", Integer.class));
		dataSource.setMaxIdle(env.getRequiredProperty("jdbc.maxIdle", Integer.class));
		dataSource.setMinIdle(env.getRequiredProperty("jdbc.minIdle", Integer.class));
		dataSource.setDefaultAutoCommit(env.getRequiredProperty("jdbc.defaultAutoCommit", Boolean.class));
		dataSource.setPoolPreparedStatements(env.getRequiredProperty("jdbc.poolPreparedStatements", Boolean.class));
		dataSource.setValidationQuery(env.getRequiredProperty("jdbc.validationQuery"));
		dataSource.setTestOnBorrow(env.getRequiredProperty("jdbc.testOnBorrow", Boolean.class));
		dataSource.setTestOnReturn(env.getRequiredProperty("jdbc.testOnReturn", Boolean.class));
		dataSource.setTestWhileIdle(env.getRequiredProperty("jdbc.testWhileIdle", Boolean.class));
		dataSource.setTimeBetweenEvictionRunsMillis(env.getRequiredProperty("jdbc.timeBetweenEvictionRunsMillis", Long.class));
		dataSource.setNumTestsPerEvictionRun(env.getRequiredProperty("jdbc.numTestsPerEvictionRun", Integer.class));
		dataSource.setMinEvictableIdleTimeMillis(env.getRequiredProperty("jdbc.minEvictableIdleTimeMillis", Long.class));
		return dataSource;
	}

	@Bean
	public DataSource userDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("user.jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("user.jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("user.jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("user.jdbc.password"));
		dataSource.setInitialSize(env.getRequiredProperty("jdbc.initialSize", Integer.class));
		dataSource.setMaxActive(env.getRequiredProperty("jdbc.maxActive", Integer.class));
		dataSource.setMaxIdle(env.getRequiredProperty("jdbc.maxIdle", Integer.class));
		dataSource.setMinIdle(env.getRequiredProperty("jdbc.minIdle", Integer.class));
		dataSource.setDefaultAutoCommit(env.getRequiredProperty("jdbc.defaultAutoCommit", Boolean.class));
		dataSource.setPoolPreparedStatements(env.getRequiredProperty("jdbc.poolPreparedStatements", Boolean.class));
		dataSource.setValidationQuery(env.getRequiredProperty("jdbc.validationQuery"));
		dataSource.setTestOnBorrow(env.getRequiredProperty("jdbc.testOnBorrow", Boolean.class));
		dataSource.setTestOnReturn(env.getRequiredProperty("jdbc.testOnReturn", Boolean.class));
		dataSource.setTestWhileIdle(env.getRequiredProperty("jdbc.testWhileIdle", Boolean.class));
		dataSource.setTimeBetweenEvictionRunsMillis(env.getRequiredProperty("jdbc.timeBetweenEvictionRunsMillis", Long.class));
		dataSource.setNumTestsPerEvictionRun(env.getRequiredProperty("jdbc.numTestsPerEvictionRun", Integer.class));
		dataSource.setMinEvictableIdleTimeMillis(env.getRequiredProperty("jdbc.minEvictableIdleTimeMillis", Long.class));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

}
