package com.github.ericdahl.spring_boot_mersenne_primes

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse;

@RestController
class MersennePrimeController {

    LucasLehmerCalculator calculator

    @Autowired
    MersennePrimeController(LucasLehmerCalculator calculator) {
        this.calculator = calculator
    }

    @RequestMapping("/{n}")
    public @ResponseBody PrimeResult checkPrimality(@PathVariable int n) {
        return calculator.checkPrimality(n)
    }
}
