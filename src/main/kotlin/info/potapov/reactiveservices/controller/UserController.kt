package info.potapov.reactiveservices.controller

import info.potapov.reactiveservices.model.Currency
import info.potapov.reactiveservices.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestParam currencyName: String): Mono<UUID> {
        return userService.createUser(currencyName)
    }

    @GetMapping("/{userId}/currency")
    fun getUserCurrency(@PathVariable userId: UUID): Mono<String> {
        return userService.getCurrencyByUserId(userId)
    }

}