package arquikotlin.example.kotlin.bl;

import arquikotlin.example.kotlin.dto.ApiDto
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import java.io.IOException
import java.math.BigDecimal

@Service
public
class CurrencyBl {
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

        val objectMapper = ObjectMapper();
        val apiDto = objectMapper.readValue(responseBody, ApiDto::class.java);
        return apiDto;
    }
}