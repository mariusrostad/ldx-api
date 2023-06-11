package no.ldx.api

import org.springframework.stereotype.Service

@Service
class ToUpperCaseService {

    fun transform(input: String): String? {
        if (input == "") {
            return null
        }
        return input.uppercase()
    }
}