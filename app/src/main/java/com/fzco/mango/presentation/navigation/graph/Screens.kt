package com.fzco.mango.presentation.navigation.graph

import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.SendAuthCodeFragment
import com.fzco.mango.presentation.screens.country.SelectCountryCodeFragment
import com.fzco.mango.presentation.screens.home.HomeFragment
import com.fzco.mango.presentation.screens.rigistration.RegisterUserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun Home() = FragmentScreen {
        HomeFragment()
    }

    fun SendAuthCode() = FragmentScreen {
        SendAuthCodeFragment()
    }

    fun SelectCountryCode() = FragmentScreen {
        SelectCountryCodeFragment()
    }

    fun ConfirmAuthCode() = FragmentScreen {
        ConfirmAuthCodeFragment()
    }

    fun RegisterUser() = FragmentScreen {
        RegisterUserFragment()
    }
}
