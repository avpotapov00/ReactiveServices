package info.potapov.reactiveservices.repository

import info.potapov.reactiveservices.model.Good
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface GoodRepository: ReactiveCrudRepository<Good, UUID>