package arquikotlin.example.kotlin.dto

import java.math.BigDecimal

class ApiDto(
    var success: Boolean,
    var query: ChangeDto?,
    var info: InfoDto?,
    var date: String?,
    var result: BigDecimal?
) {
    constructor() : this(false, null, null, null, null)

    override fun toString(): String {
        return "ApiDto(success=$success, query=$query, info=$info, date=$date, result=$result)"
    }
}