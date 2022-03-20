package info.potapov.reactiveservices.repository

import info.potapov.reactiveservices.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface UserRepository : ReactiveCrudRepository<User, UUID>