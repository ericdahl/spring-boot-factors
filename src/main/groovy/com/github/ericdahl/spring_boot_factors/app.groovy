package com.github.ericdahl.spring_boot_factors

import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.web.filter.ShallowEtagHeaderFilter

import javax.servlet.Filter

@SpringBootApplication
@EnableCaching
class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }

    @Bean
    public CacheManager cacheManager(CounterService counterService) {
        new SimpleCacheManager(caches: [new CountingMapCache("factors", counterService)])
    }

    @Bean
    public Filter etagFilter() {
        new ShallowEtagHeaderFilter()
    }
}
