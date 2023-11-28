package com.jli.countrycollection.countrylist

import com.jli.countrycollection.countryapi.CountryListServiceFactory

//Serves as a simple globally-scoped DI container for the CountryList feature
object CountryListContainer {
    val countryListService = CountryListServiceFactory().create()
    val countryListRepository: CountryRepository = CountryRepositoryImpl(countryListService)
}