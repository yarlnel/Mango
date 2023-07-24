package com.fzco.mango.presentation.screens.country

import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.utils.common.countryCodeToEmoji
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import java.util.Locale
import javax.inject.Inject

class SelectCountryCodeViewModel @Inject constructor(
    private val phoneUtil: PhoneNumberUtil
) : BaseViewModel<SelectCountryCodeState, SelectCountryCodeSideEffect>() {

    override val initialState = SelectCountryCodeState()

    init {
        loadCountries()
    }

    private var allCountries = emptyList<SelectCountryCodeState.CountryData>()

    fun loadCountries() = intent {
        val countriesData = phoneUtil.supportedRegions.map { region ->
            val countryName = Locale("", region).displayName
            val countryEmoji = countryCodeToEmoji(region)

            SelectCountryCodeState.CountryData(
                countryEmoji,
                countryName,
                region
            )
        }

        allCountries = countriesData
        reduce {
            state.copy(countries = countriesData)
        }
    }

    fun searchCountry(text: String) = intent {
        val filteredCountries = allCountries.filter { text.lowercase() in it.countryName.lowercase() }
        reduce {
            state.copy(countries = filteredCountries)
        }
    }
}
