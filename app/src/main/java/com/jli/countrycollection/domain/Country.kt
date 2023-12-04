package com.jli.countrycollection.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String,
    val region: String,
    val code: String,
    val capital: String
): Parcelable