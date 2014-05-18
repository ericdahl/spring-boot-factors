package com.github.ericdahl.spring_boot_mersenne_primes

import spock.lang.Specification

class LucasLehmerCalculatorSpec extends Specification {

    LucasLehmerCalculator calculator = new LucasLehmerCalculator()

    def "prime check"() {
        expect:
        calculator.checkPrimality(n).prime == expectedPrimality

        where:
        n   | expectedPrimality
        2   | true
        3   | true
        4   | false
        5   | true
        6   | false
        7   | true
        8   | false
        9   | false
        10  | false
        11  | false
        12  | false
        13  | true
        31  | true
        107 | true
    }
}
