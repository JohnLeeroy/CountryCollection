package com.jli.countrycollection

import com.jli.countrycollection.countryapi.CountryListService
import com.jli.countrycollection.countryapi.model.CLSCountry
import com.jli.countrycollection.countrylist.CountryRepository
import com.jli.countrycollection.countrylist.CountryRepositoryImpl
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.BufferedSource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    lateinit var service: CountryListService

    lateinit var repository: CountryRepositoryImpl

    @Test
    fun addition_isCorrect() = runTest {
        service = object : CountryListService {
            override suspend fun fetchCountryList(): Response<List<CLSCountry>> {
                return Response.error(501, object: ResponseBody() {
                    override fun contentLength(): Long = 0

                    override fun contentType(): MediaType? = null

                    override fun source(): BufferedSource {
                        throw Exception("Should never throw")
                    }
                })
            }
        }
        repository = CountryRepositoryImpl(service)
        val result = repository.getCountries()
        assert(result.isEmpty())
    }
}