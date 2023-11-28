package com.jli.countrycollection.countryapi.model

import com.squareup.moshi.Json

data class CLSLanguage(
    val code: String?,
    val name: String,
    @Json(name = "iso639_2")
    val iso6392: String?,
    val nativeName: String?,
)