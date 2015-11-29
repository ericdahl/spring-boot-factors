package com.github.ericdahl.spring_boot_factors

import spock.lang.Specification

class SimpleFactorServiceSpec extends Specification {

    SimpleFactorService calculator = new SimpleFactorService()

    def "factor check"() {
        expect:
        calculator.factorize(n) == result

        where:
        n   | result
        7   | [7]
        2   | [2]
        12  | [2, 2, 3]
        24  | [2, 2, 2, 3]
    }
}
