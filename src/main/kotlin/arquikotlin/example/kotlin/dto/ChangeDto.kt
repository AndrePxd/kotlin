package arquikotlin.example.kotlin.dto;

import java.math.BigDecimal;
data class ChangeDto(var from: String, var to: String, var amount:BigDecimal) {
    override fun toString(): String {
        return "ChangeDto(from='$from', to='$to', amount=$amount)";
    }
}