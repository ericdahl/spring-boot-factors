package com.github.ericdahl.spring_boot_factors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Component

@Component
class AppHealthIndicator implements HealthIndicator {

    @Autowired
    FactorService calculator

    @Autowired
    CacheManager cacheManager

    @Override
    Health health() {
        return new Health.Builder()
                .up()
                .withDetail('service', calculator.factorize(7) == [7])
                .build()
    }
}
