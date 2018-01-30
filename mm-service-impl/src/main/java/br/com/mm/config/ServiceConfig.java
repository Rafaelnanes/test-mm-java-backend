package br.com.mm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.mm.service.impl" })
public class ServiceConfig {

}
