package info.potapov.reactiveservices.controller

import info.potapov.reactiveservices.service.AssortmentService
import info.potapov.reactiveservices.service.GoodService
import info.potapov.reactiveservices.view.GoodView
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/goods")
class GoodController(
    val assortmentService: AssortmentService,
    val goodService: GoodService,
) {

    @PostMapping
    fun create(@RequestParam price: Double, @RequestParam name: String): Mono<UUID> {
        return goodService.createGood(price, name)
    }

    @GetMapping("/all/user/{userId}")
    fun getAssortment(@PathVariable userId: UUID): Flux<GoodView> {
        return assortmentService.viewForUser(userId)
    }

}