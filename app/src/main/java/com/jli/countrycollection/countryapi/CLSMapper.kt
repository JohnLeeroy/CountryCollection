package com.jli.countrycollection.countryapi

import com.jli.countrycollection.countryapi.model.CLSCountry
import com.jli.countrycollection.domain.Country

fun CLSCountry.toDomainCountry(): Country {
    return Country(name, region, code, capital)
}