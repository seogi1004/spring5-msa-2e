package com.rvslab.chapter3.bootactuator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.metrics.CounterService
import org.springframework.boot.actuate.metrics.GaugeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController @Autowired constructor(var health: TPSHealth, var counterService: CounterService, var gaugeService: GaugeService) {
    @GetMapping("/greeting")
    fun greet() : Greet {
        health.updateTx()
        counterService.increment("greet.txnCount")
        gaugeService.submit("greet.customgauge", 1.0)
        return Greet("Hello World!")
    }
}

data class Greet(val message: String)