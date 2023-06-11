package no.ldx.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LdxApiApplication

fun main(args: Array<String>) {
    runApplication<LdxApiApplication>(*args)
}
