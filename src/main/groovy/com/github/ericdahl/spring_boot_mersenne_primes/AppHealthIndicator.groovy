package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Component

@Component
class AppHealthIndicator implements HealthIndicator {

    @Autowired
    MersennePrimeCalculator calculator

    @Autowired
    CacheManager cacheManager

    @Override
    Map health() {
        return [
            'calculator': calculator.checkPrimality(7).prime,
            'cacheManager': null != cacheManager.getCache("mersennePrimes").get(7, PrimeResult.class)
        ]
    }
}
