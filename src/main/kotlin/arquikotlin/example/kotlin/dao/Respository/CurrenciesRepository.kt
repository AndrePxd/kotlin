package arquikotlin.example.kotlin.dao.Respository

import arquikotlin.example.kotlin.dao.Currency
import org.springframework.data.repository.PagingAndSortingRepository

interface CurrenciesRepository : PagingAndSortingRepository<Currency, Long> {

}