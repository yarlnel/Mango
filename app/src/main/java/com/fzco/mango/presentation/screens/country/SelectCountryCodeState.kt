package com.fzco.mango.presentation.screens.country

import com.fzco.mango.presentation.common.viewmodel.contract.IState

data class SelectCountryCodeState(
    val countries: List<CountryData> = emptyList()
) : IState {

    data class CountryData(
        val countryEmoji: String,
        val countryName: String,
        val countryCode: String
    )
}