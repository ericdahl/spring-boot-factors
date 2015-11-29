package com.github.ericdahl.spring_boot_factors

//import groovy.util.logging.Slf4j
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

//@Slf4j
@Service
class SimpleFactorService implements FactorService {

    @Cacheable("factors")
    List<Integer> factorize(int n) {

//        log.info('Processing request for [{}]', n);

        List<Integer> factors = []

        for (int i = 2; n > 1;) {
            while (n % i == 0) {
                factors << i
                n /= i
            }
            i++
        }
        return factors;
    }
}
