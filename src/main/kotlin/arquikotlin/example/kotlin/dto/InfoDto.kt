package arquikotlin.example.kotlin.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

data class InfoDto(var timestamp: BigInteger, var rate: BigDecimal) {
    override fun toString(): String {
        return "InfoDto(timestamp=$timestamp, rate=$rate)"
    }
}