package com.assessment2.assessment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class Assessment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assessment2Application.class, args);
	}
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("employee");
	}

}
