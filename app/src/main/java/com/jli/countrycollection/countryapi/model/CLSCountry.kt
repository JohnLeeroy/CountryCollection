package com.jli.countrycollection.countryapi.model

data class CLSCountry(
    val capital: String,
    val code: String,
    val currency: CLSCurrency,
    val flag: String,
    val language: CLSLanguage,
    val name: String,
    val region: String,
    val demonym: String?
)

