package com.github.ericdahl.spring_boot_factors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController

@RestController
class FactorsController {

    private final FactorService service

    @Autowired
    FactorsController(FactorService service) {
        this.service = service
    }

    @RequestMapping("/{n}")
    public List<Integer> factorize(@PathVariable int n) {
        return service.factorize(n)
    }
}
