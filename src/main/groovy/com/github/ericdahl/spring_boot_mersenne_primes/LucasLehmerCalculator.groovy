package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.stereotype.Service

@Service
class LucasLehmerCalculator {

    PrimeResult checkPrimality(int n) {
        if (n == 2) {
            return new PrimeResult(n: 2, prime: true)
        }

        def s = 4
        def m = 2 ** n - 1
        0.upto(n - 3) {
            s = (s ** 2 - 2) % m
        }

        return new PrimeResult(n: n, prime: s == 0)
    }
}
