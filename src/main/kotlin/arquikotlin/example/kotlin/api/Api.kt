package arquikotlin.example.kotlin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import arquikotlin.example.kotlin.bl.CurrencyBl;
import arquikotlin.example.kotlin.dto.ApiDto
import arquikotlin.example.kotlin.dto.ResponseDto;
import org.hibernate.bytecode.BytecodeLogging.LOGGER
import java.math.BigDecimal;



@RestController
@RequestMapping("v1/change")
class Api(val currencyBl: CurrencyBl) {


    @GetMapping("/history")
    fun getConvertions(
        @RequestParam page: Int,
        @RequestParam size: Int
    ) : ResponseEntity<Any> {
        val convertions = currencyBl.getConvertions(page, size);
        LOGGER.info("200 OK")
        return ResponseEntity.ok(convertions)
    }

    @GetMapping("/coin")
    fun getChange(@RequestParam from: String, @RequestParam to:String, @RequestParam amount: BigDecimal): ResponseEntity<ApiDto> {
        val apiDto = currencyBl.getExchange(from, to, amount);
        return ResponseEntity.ok(apiDto);
    }
}
