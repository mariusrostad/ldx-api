package no.ldx.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

data class StandardBadRequestApiException(
    override val message: String,
    val missingProperties: List<MissingProperty>
) : Exception(message)

@RestControllerAdvice
class RestControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [StandardBadRequestApiException::class])
    fun handleStandardBadRequestApiException(exception: StandardBadRequestApiException): ResponseEntity<ApiError> {
        val status = HttpStatus.BAD_REQUEST
        val response = ApiError(
            status = status.value(),
            message = exception.message,
            missingProperties = exception.missingProperties
        )
        return ResponseEntity.badRequest().body(response)
    }
}
