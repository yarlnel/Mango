package com.fzco.mango.presentation.screens.auth.send.vm


import com.fzco.mango.domain.usecase.auth.SendAuthCode
import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.navigation.graph.Screens
import com.fzco.mango.presentation.screens.auth.send.contract.SendAuthCodeSideEffect
import com.fzco.mango.presentation.screens.auth.send.contract.SendAuthCodeState
import com.fzco.mango.presentation.utils.viewmodel.loading.intentLoading
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

class SendAuthCodeViewModel @Inject constructor (
    private val router: Router,
    private val sendAuthCode: SendAuthCode,
) : BaseViewModel<SendAuthCodeState, SendAuthCodeSideEffect>() {

    override val initialState = SendAuthCodeState()

    fun updatePhone(phone: String) = intent {
        reduce {
            state.copy(phone = phone)
        }
    }

    fun requestSendAuthCode(phone: String) = intent {
        reduce { state.copy(isLoading = true) }
        val isSuccess = sendAuthCode(phone)
        if (isSuccess) {
            router.navigateTo(Screens.ConfirmAuthCode())
        } else {
            postSideEffect(SendAuthCodeSideEffect.SendAuthError)
        }
        reduce { state.copy(isLoading = false) }
    }

    fun openSelectCountryScreen() = intent {
        router.navigateTo(Screens.SelectCountryCode())
    }

    fun updateCountryCode(countryCode: String) = intent {
        reduce {
            state.copy(countryCode = countryCode)
        }
    }
}
