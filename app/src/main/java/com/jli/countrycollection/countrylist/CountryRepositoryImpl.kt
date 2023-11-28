package com.jli.countrycollection.countrylist

import com.jli.countrycollection.countryapi.CountryListService
import com.jli.countrycollection.countryapi.toDomainCountry
import com.jli.countrycollection.domain.Country
import timber.log.Timber

class CountryRepositoryImpl(private val clsService: CountryListService) : CountryRepository {
    override suspend fun getCountries(): List<Country> {
        // TODO add in-memory or disk-caching
        val result = clsService.fetchCountryList()
        if (result.isSuccessful) {
            return result.body()?.map { clsCountry ->
                clsCountry.toDomainCountry()
            } ?: emptyList()
        } else {
            Timber.d("Error fetching getCountries: ${result.errorBody().toString()}")
        }
        return emptyList()
    }

}