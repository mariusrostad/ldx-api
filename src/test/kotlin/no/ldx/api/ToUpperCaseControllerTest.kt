package no.ldx.api

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class ToUpperCaseControllerTest {

    @Test
    fun shouldTransformStringToUpperCase() {
        val input = "String in lower case"
        val service = ToUpperCaseService()
        val controller = ToUpperCaseController(service)

        val response = controller.toUpperCase(input)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals("STRING IN LOWER CASE", response.body)
    }

    @Test
    fun emptyInputShouldResultInBadRequest() {
        val input = ""
        val service = ToUpperCaseService()
        val controller = ToUpperCaseController(service)

        val result = controller.toUpperCase(input)

        assertEquals(HttpStatus.BAD_REQUEST, result.statusCode)
        assertNull(result.body)
    }
}