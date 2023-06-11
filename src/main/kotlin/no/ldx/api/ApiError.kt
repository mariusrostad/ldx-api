package no.ldx.api

data class ApiError(
    val status: Int,
    val message: String,
    val missingProperties: List<MissingProperty>,
)

data class MissingProperty(
    val key: String,
    val value: String,
    val explanation: String,
)
