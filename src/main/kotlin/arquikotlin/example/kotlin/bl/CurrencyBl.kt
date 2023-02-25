package arquikotlin.example.kotlin.bl;

import arquikotlin.example.kotlin.dao.Currency
import arquikotlin.example.kotlin.dao.Respository.CurrencyRepository
import arquikotlin.example.kotlin.dto.ApiDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.hibernate.bytecode.BytecodeLogging.LOGGER

import org.springframework.stereotype.Service
import java.io.IOException
import java.math.BigDecimal
import java.util.*

@Service
public
class CurrencyBl(private val currencyRepository: CurrencyRepository) {
    @Throws(IOException::class)
    fun getExchange(from: String, to: String, amount: BigDecimal): ApiDto? {
        if (amount <= BigDecimal.ZERO) {
            throw IllegalArgumentException("El monto debe ser mayor a 0");
        }
        val client = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/convert?to=$to&from=$from&amount=$amount")
            .addHeader("apikey", "HhvYSUHpiQWsUZ79MC3FTHd2TdD0R6g3")
            .build();
        val response = client.newCall(request).execute();
        val responseBody = response.body().string();
        println(responseBody)

        if(response.isSuccessful){
            LOGGER.info("La respuesta fue exitosa")
            val xd = ObjectMapper();
            val currencyDto = xd.readValue(responseBody, ApiDto::class.java)
            val currency: Currency = Currency()
            currency.currencyFrom = from
            currency.currencyTo = to
            currency.amount = amount
            currency.result = currencyDto.result!!
            currency.date = Date()
            currencyRepository.save(currency)
            LOGGER.info("Conversion result: ${responseBody}")
        }

        val objectMapper = ObjectMapper();
        val apiDto = objectMapper.readValue(responseBody, ApiDto::class.java);
        return apiDto;
    }
}