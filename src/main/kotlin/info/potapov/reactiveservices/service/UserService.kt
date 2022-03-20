package info.potapov.reactiveservices.service

import info.potapov.reactiveservices.exception.CurrencyNotFoundException
import info.potapov.reactiveservices.exception.UserNotFoundException
import info.potapov.reactiveservices.model.User
import info.potapov.reactiveservices.repository.CurrencyRepository
import info.potapov.reactiveservices.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import java.util.*

@Service
class UserService(
    val repository: UserRepository,
    val currencyRepository: CurrencyRepository
) {

    fun createUser(currencyName: String): Mono<UUID> {
        return Mono.just(currencyName)
            .filterWhen { currencyRepository.existsByName(it) }
            .switchIfEmpty { Mono.error { CurrencyNotFoundException(currencyName) } }
            .flatMap { repository.save(User(UUID.randomUUID(), currencyName)) }
            .map { it.id }
    }

    fun getCurrencyByUserId(id: UUID): Mono<String> {
        return repository.findById(id).map { it.currencyName }
    }

    fun getUser(id: UUID): Mono<User> {
        return repository.findById(id)
            .switchIfEmpty { Mono.error { UserNotFoundException(id) } }
    }

}