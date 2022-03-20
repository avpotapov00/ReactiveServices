package info.potapov.reactiveservices.service

import info.potapov.reactiveservices.exception.CurrencyNotFoundException
import info.potapov.reactiveservices.model.Currency
import info.potapov.reactiveservices.repository.CurrencyRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class CurrencyService(
    val currencyRepository: CurrencyRepository
) {

    fun create(name: String, usdEquivalent: Double): Mono<Void> {
         return currencyRepository.save(Currency(name, usdEquivalent)).then()
    }

    fun getCurrency(name: String): Mono<Currency> {
        return currencyRepository.findByName(name)
            .switchIfEmpty { Mono.error { CurrencyNotFoundException(name) } }
    }

}