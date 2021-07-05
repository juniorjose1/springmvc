package br.com.alexandre.springmvcwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.alexandre.springmvcwebapp.interceptors.InterceptadorDeAcessos;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	InterceptadorDeAcessos interceptadorDeAcessos;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptadorDeAcessos).addPathPatterns("/**");
	}

}
