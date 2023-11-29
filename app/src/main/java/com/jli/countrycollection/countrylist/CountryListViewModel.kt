package com.jli.countrycollection.countrylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.jli.countrycollection.R
import com.jli.countrycollection.StringResource
import com.jli.countrycollection.countrylist.ui.CountryUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

sealed class CountryListState {
    data object Uninitialized : CountryListState()
    data object Loading : CountryListState()
    data class CountryListFetched(val countryList: List<CountryUiModel>) : CountryListState()
    class Error(val message: String) :
        CountryListState()   // not a data class to allow consecutive emits
}

class CountryListViewModel(
    private val countryRepository: CountryRepository,
    private val stringResource: StringResource
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<CountryListState>(CountryListState.Uninitialized)
    val uiState: StateFlow<CountryListState> = _uiState.asStateFlow()
    fun getCountryList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _uiState.emit(CountryListState.Loading)
                val countries = countryRepository.getCountries().map { country ->
                    CountryUiModel(country.name, country.region, country.code, country.capital)
                }
                _uiState.emit(CountryListState.CountryListFetched(countries))
            } catch (e: Throwable) {
                Timber.d(e)
                _uiState.emit(CountryListState.Error(stringResource.get(R.string.network_error_fetching_country_list)))
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
                // This type of global DI isn't ideal.
                // Ideally, we create a factory within the scope/context of the feature
                // such as in CountryListFragment, and use constructor injection to create the
                // VM factory which wil pass the dependencies into the VM
                return CountryListViewModel(
                    CountryListContainer.countryListRepository,
                    CountryListContainer.stringResource
                ) as T
            }
        }
    }
}