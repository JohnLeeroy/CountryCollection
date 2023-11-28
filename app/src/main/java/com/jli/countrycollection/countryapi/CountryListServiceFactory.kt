package com.jli.countrycollection.countryapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CountryListServiceFactory {

    fun create(): CountryListService {
        val clientBuilder = OkHttpClient.Builder()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CountryListService::class.java)
    }

    companion object {
        private const val baseUrl =
            "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
    }
}