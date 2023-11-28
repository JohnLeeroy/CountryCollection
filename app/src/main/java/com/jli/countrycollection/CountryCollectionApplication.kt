package com.jli.countrycollection

import android.app.Application
import timber.log.Timber

class CountryCollectionApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}