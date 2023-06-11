package no.ldx.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ToUpperCaseController(
    val toUpperCaseService: ToUpperCaseService
) {


    @GetMapping
    @Throws(exceptionClasses = [StandardBadRequestApiException::class])
    fun toUpperCase(input: String): ResponseEntity<String?> {
        val transformed = toUpperCaseService.transform(input) ?: return ResponseEntity.badRequest().body(null)
        return ResponseEntity.ok(transformed)
    }
}