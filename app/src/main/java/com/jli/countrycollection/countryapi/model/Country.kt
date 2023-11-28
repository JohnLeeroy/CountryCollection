package com.jli.countrycollection.countryapi.model

data class Country(
    val capital: String,
    val code: String,
    val currency: Currency,
    val flag: String,
    val language: Language,
    val name: String,
    val region: String,
    val demonym: String?
)

