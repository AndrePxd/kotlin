package arquikotlin.example.kotlin.dao.Respository

import arquikotlin.example.kotlin.dao.Currency
import org.springframework.data.repository.CrudRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable



interface CurrencyRepository: CrudRepository<Currency, Long>{
    fun findAll(pageable: Pageable): Page<Currency>
}