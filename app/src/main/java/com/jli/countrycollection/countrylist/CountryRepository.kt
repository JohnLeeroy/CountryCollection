package com.jli.countrycollection.countrylist

import com.jli.countrycollection.domain.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}

