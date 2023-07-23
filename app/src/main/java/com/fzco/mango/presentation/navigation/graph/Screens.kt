package com.fzco.mango.presentation.navigation.graph

import com.fzco.mango.presentation.screens.auth.confirm.ui.ConfirmAuthCodeFragment
import com.fzco.mango.presentation.screens.auth.send.ui.SendAuthCodeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun SendAuthCode() = FragmentScreen {
        SendAuthCodeFragment()
    }

    fun ConfirmAuthCode() = FragmentScreen {
        ConfirmAuthCodeFragment()
    }
}
