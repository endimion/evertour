package com.evertour.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({ "com.evertour.aspects", "com.evertour.model", "om.evertour.model.DAOImpl",
		"com.evertour.services.impl", "com.evertour.controllers" })
@EnableWebMvc // same as <mvc:annotation-driven/>
@EnableAspectJAutoProxy // same as: <aop:aspectj-autoproxy />
@ImportResource({ "classpath:testDataSource.xml" })
public class TestConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	// same as : <mvc:resources mapping="/resources/**" location="/resources/"/>
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// same as <mvc:default-servlet-handler/>
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
		/**
		 * same as <!-- the property JstlView allows us to use jstl tags in the
		 * jsp file --> <bean class=
		 * "org.springframework.web.servlet.view.InternalResourceViewResolver">
		 * <property name="viewClass"
		 * value="org.springframework.web.servlet.view.JstlView" /> <property
		 * name="prefix" value="/WEB-INF/views/"/> <property name="suffix"
		 * value=".jsp"/> </bean>
		 * 
		 */
	}


}// end of class