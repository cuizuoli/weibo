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

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * Security Configuration.
 * @author cuizuoli
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private DataSource userDataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
		userDetailsService.setDataSource(userDataSource);
		userDetailsService.setEnableGroups(true);
		return userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/connect", "/connect/**", "/login", "/", "/index.html", "/components/**", "/css/**", "/images/**").permitAll()
			.antMatchers("/weibo/**").hasRole("WEIBO")
			.antMatchers("/a/**").hasRole("WEIBO_ADMIN")
			.anyRequest().anonymous()
			.and().formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/j_spring_security_check")
			.usernameParameter("username")
			.passwordParameter("password")
			.defaultSuccessUrl("/weibo", true)
			.failureUrl("/login")
			.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.and().httpBasic()
			.and().rememberMe()
			.and().sessionManagement()
			.maximumSessions(10)
			.maxSessionsPreventsLogin(true);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		auth.authenticationProvider(authenticationProvider);
	}

	@Bean
	public LoggerListener loggerListener() {
		return new LoggerListener();
	}

}
