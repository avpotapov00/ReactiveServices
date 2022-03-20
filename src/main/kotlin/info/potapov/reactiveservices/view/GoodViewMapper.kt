package info.potapov.reactiveservices.view

import info.potapov.reactiveservices.model.Good
import org.springframework.stereotype.Component

@Component
class GoodViewMapper {

    fun toViewWithAnotherRate(good: Good, rate: Double): GoodView {
        return GoodView(
            id = good.id,
            name = good.name,
            price = good.price * rate
        )
    }

}