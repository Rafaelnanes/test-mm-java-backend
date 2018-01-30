package br.com.mm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { //
	"br.com.mm.config", //
	"br.com.mm.api.controllers" })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

}