package arquikotlin.example.kotlin.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

data class InfoDto(var timestamp: BigInteger?, var rate: BigDecimal?) {
    constructor() : this(null, null)
    override fun toString(): String {
        return "InfoDto(timestamp=$timestamp, rate=$rate)"
    }

}