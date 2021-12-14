package feature.examples.screensnavigation.model

import java.io.Serializable

data class StrangePerson(
    val name: String,
    val age: Int,
    val address: Address
) : Serializable

data class Address(
    val street: String,
    val postalCode: Long
) : Serializable
