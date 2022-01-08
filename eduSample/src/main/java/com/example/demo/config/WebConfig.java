package com.example.demo.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public TilesConfigurer tileConfigurer() {
		final TilesConfigurer config = new TilesConfigurer();
		String[] def = {"/WEB-INF/config/tiles.xml"}; 
		config.setDefinitions(def);
		config.setCheckRefresh(true);
		return config;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean
	public RestTemplate myRestTemplateBuilder(RestTemplateBuilder builder) {
		builder.setConnectTimeout(Duration.ofMillis(10000));
		builder.setReadTimeout(Duration.ofMillis(10000));
		return builder.build();
	}
}
