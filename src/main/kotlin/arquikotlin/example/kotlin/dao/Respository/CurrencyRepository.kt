package arquikotlin.example.kotlin.dao.Respository

import arquikotlin.example.kotlin.dao.Currency
import org.springframework.data.repository.CrudRepository


interface CurrencyRepository: CrudRepository<Currency, Long>