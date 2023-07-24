package com.fzco.mango.presentation.navigation.graph

import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.SendAuthCodeFragment
import com.fzco.mango.presentation.screens.country.SelectCountryCodeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun SendAuthCode() = FragmentScreen {
        SendAuthCodeFragment()
    }

    fun ConfirmAuthCode() = FragmentScreen {
        ConfirmAuthCodeFragment()
    }

    fun SelectCountryCode() = FragmentScreen {
        SelectCountryCodeFragment()
    }
}
