package arquikotlin.example.kotlin.dto;

data class ResponseDto<T> @JvmOverloads constructor(
    var success: Boolean = false,
    var data: T? = null,
    var message: String? = null
) {
    override fun toString(): String {
        return "ResponseDto(success=$success, data=$data, message=$message)"
    }
}
