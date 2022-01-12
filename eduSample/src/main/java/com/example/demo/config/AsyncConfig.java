package com.example.demo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig extends AsyncConfigurerSupport{
	//TaskRejectedException: 풀 꽉차면 발생
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(30);
		executor.setQueueCapacity(50);
		executor.setThreadNamePrefix("EDU-ASYNC-");
		executor.initialize();
		return executor;
	}
}
