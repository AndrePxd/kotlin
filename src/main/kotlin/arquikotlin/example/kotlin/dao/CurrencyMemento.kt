package arquikotlin.example.kotlin.dao

import java.math.BigDecimal
import java.util.*

class CurrencyMemento(
    val currencyFrom: String,
    val currencyTo: String,
    val amount: BigDecimal,
    val result: BigDecimal,
    val date: Date
)


