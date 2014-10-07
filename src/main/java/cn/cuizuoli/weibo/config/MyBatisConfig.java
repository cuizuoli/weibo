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

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Repository;

/**
 * MyBatis Configuration.
 * @author cuizuoli
 */
@Configuration
@MapperScan(basePackages = "cn.cuizuoli.weibo.repository", annotationClass = Repository.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfig {

	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	@Resource
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("cn.cuizuoli.weibo.model");
		sessionFactory.setMapperLocations(resourcePatternResolver.getResources("classpath:cn/cuizuoli/weibo/repository/*Repository.xml"));
		return sessionFactory.getObject();
	}

}
