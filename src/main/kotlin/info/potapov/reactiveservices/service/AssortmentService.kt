package info.potapov.reactiveservices.service

import info.potapov.reactiveservices.exception.CurrencyNotFoundException
import info.potapov.reactiveservices.exception.UserNotFoundException
import info.potapov.reactiveservices.model.Currency
import info.potapov.reactiveservices.model.User
import info.potapov.reactiveservices.repository.CurrencyRepository
import info.potapov.reactiveservices.repository.GoodRepository
import info.potapov.reactiveservices.repository.UserRepository
import info.potapov.reactiveservices.view.GoodView
import info.potapov.reactiveservices.view.GoodViewMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class AssortmentService(
    val goodRepository: GoodRepository,
    val currencyService: CurrencyService,
    val goodViewMapper: GoodViewMapper,
    val userService: UserService
) {

    fun viewForUser(userId: UUID): Flux<GoodView> {
        return userService.getUser(userId)
            .flatMap { user -> currencyService.getCurrency(user.currencyName) }
            .flatMapMany { currencyRate -> mapGoodWithRate(currencyRate) }
    }

    private fun mapGoodWithRate(currencyRate: Currency) =
        goodRepository.findAll().map { good -> goodViewMapper.toViewWithAnotherRate(good, currencyRate.usdEquivalent) }

}