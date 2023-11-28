package com.jli.countrycollection.countrylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.jli.countrycollection.countrylist.ui.CountryUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class CountryListViewModel(private val countryRepository: CountryRepository) : ViewModel() {

    private val _uiState =
        MutableStateFlow<List<CountryUiModel>>(emptyList())
    val uiState: StateFlow<List<CountryUiModel>> = _uiState.asStateFlow()
    fun getCountryList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countries = countryRepository.getCountries().map { country ->
                    CountryUiModel(country.name, country.region, country.code, country.capital)
                }
                _uiState.emit(countries)
            } catch (e: Throwable) {
                // TODO alert UI of issues here
                // consider retry with exponential backoff
                Timber.d(e)
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return CountryListViewModel(
                    CountryListContainer.countryListRepository
                ) as T
            }
        }
    }
}