package br.com.mm.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { //
	"br.com.mm.config", //
	"br.com.mm.api.handlers", //
	"br.com.mm.api.controllers" })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean(initMethod = "migrate")
    @DependsOn("dataSource")
    public Flyway flyway() {
	Flyway flyway = new Flyway();
	flyway.setDataSource(dataSource);
	return flyway;
    }

}