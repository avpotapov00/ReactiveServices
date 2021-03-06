package info.potapov.reactiveservices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class ReactiveServicesApplication

fun main(args: Array<String>) {
    runApplication<ReactiveServicesApplication>(*args)
}
