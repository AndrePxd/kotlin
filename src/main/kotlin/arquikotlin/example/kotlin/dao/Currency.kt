package arquikotlin.example.kotlin.dao

import org.keycloak.models.AbstractKeycloakTransaction.logger
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "currency")
class Currency (

    var currencyFrom: String,
    var currencyTo: String,
    var amount: BigDecimal,
    var result: BigDecimal,
    var date: Date,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
)
{

    constructor() : this("", "", BigDecimal.ZERO, BigDecimal.ZERO, Date()) {
    }


    fun createMemento(): CurrencyMemento {

        logger.info("Resultado actual: $result")
        return CurrencyMemento(currencyFrom, currencyTo, amount, result, date)
    }

    fun restoreFromMemento(memento: CurrencyMemento) {


        currencyFrom = memento.currencyFrom
        currencyTo = memento.currencyTo
        amount = memento.amount
        result = memento.result
        date = memento.date

        logger.info("Resultado restaurado: $result")

        // Imprimir los valores restaurados y actuales
    }
}
