package info.potapov.reactiveservices.controller

import info.potapov.reactiveservices.service.CurrencyService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/currency")
class CurrencyController(
    val currencyRateService: CurrencyService
) {

    @PostMapping
    fun create(
        @RequestParam currencyString: String,
        @RequestParam usdEquivalent: Double
    ): Mono<Void> {
        return currencyRateService.create((currencyString), usdEquivalent)
    }

}