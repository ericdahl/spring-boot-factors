package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.ShallowEtagHeaderFilter

import javax.servlet.Filter

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableCaching
class app {

     public static void main(String[] args) {
         SpringApplication springApp = new SpringApplication(app.class)
         springApp.showBanner = false
         springApp.run(args)
     }

    @Bean
    public CacheManager cacheManager() {
        new SimpleCacheManager(caches: [new ConcurrentMapCache("mersennePrimes")])
    }

    @Bean
    public Filter etagFilter() {
        new ShallowEtagHeaderFilter()
    }
}
