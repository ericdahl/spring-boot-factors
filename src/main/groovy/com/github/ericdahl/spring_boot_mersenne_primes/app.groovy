package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
class app {
     public static void main(String[] args) {
         SpringApplication springApp = new SpringApplication(app.class)
         springApp.showBanner = false
         springApp.run(args)
     }
}
