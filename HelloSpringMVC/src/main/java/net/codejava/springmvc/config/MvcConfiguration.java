package net.codejava.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import net.codejava.springmvc.dao.ContactDAO;
import net.codejava.springmvc.dao.ContactDAOImpl;

@Configuration
@ComponentScan(basePackages="net.codejava.springmvc")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurationSupport {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public ContactDAO getContacDAO() {
		return new ContactDAOImpl(getDataSource());
	}
	
	@Bean
	public ViewResolver getCsvViewResolver() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(1);
		
		return resolver;
	}

}
