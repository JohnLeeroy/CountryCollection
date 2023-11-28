package com.jli.countrycollection.countryapi

import com.jli.countrycollection.countryapi.model.CLSCountry
import retrofit2.Response
import retrofit2.http.GET

interface CountryListService {
    @GET("countries.json")
    suspend fun fetchCountryList(): Response<List<CLSCountry>>
}