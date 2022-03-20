package info.potapov.reactiveservices.repository

import info.potapov.reactiveservices.model.Currency
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface CurrencyRepository: ReactiveCrudRepository<Currency, String> {

    fun findByName(name: String): Mono<Currency>

    fun existsByName(name: String): Mono<Boolean>

}