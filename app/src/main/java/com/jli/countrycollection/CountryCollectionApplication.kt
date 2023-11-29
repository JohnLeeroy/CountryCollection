package com.jli.countrycollection

import android.app.Application
import com.jli.countrycollection.countrylist.CountryListContainer
import timber.log.Timber

class CountryCollectionApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        initializeDependencies()
    }

    private fun initializeDependencies() {
        CountryListContainer.stringResource = object : StringResource {
            override fun get(stringResId: Int): String = getString(stringResId)
        }
    }
}