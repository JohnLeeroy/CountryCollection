package com.jli.countrycollection.countrylist.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CountryUiModel(
    val name: String,
    val region: String,
    val code: String,
    val capital: String
): Parcelable