package com.jli.countrycollection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.jli.countrycollection.countryapi.CountryListService
import com.jli.countrycollection.countryapi.CountryListServiceFactory
import com.jli.countrycollection.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryService = CountryListServiceFactory().create()
        lifecycleScope.launch(Dispatchers.IO) {
            val response = countryService.fetchCountryList()
            Timber.d(response.body().toString())
            withContext(Dispatchers.Main) {
                // https://restcountries.eu/data/lso.svg

            }
        }
    }
}
