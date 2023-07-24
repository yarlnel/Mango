package com.fzco.mango.presentation.screens.auth.send


import com.fzco.mango.domain.usecase.auth.SendAuthCode
import com.fzco.mango.domain.usecase.user.phone.SaveUserPhoneData
import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.navigation.graph.Screens
import com.github.terrakok.cicerone.Router
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class SendAuthCodeViewModel(
    private val router: Router,
    private val sendAuthCode: SendAuthCode,
    private val saveUserPhoneData: SaveUserPhoneData
) : BaseViewModel<SendAuthCodeState, SendAuthCodeSideEffect>() {

    override val initialState = SendAuthCodeState()

    fun updatePhone(phone: String) = intent {
        reduce {
            state.copy(phone = phone)
        }
    }

    fun requestSendAuthCode(phone: String) = intent {
        reduce {
            state.copy(isLoading = true)
        }

        val result = saveUserPhoneData(phone, state.countryCode)
        if (result is SaveUserPhoneData.Result.PhoneValidationError) {
            postSideEffect(SendAuthCodeSideEffect.InvalidPhone)
            reduce {
                state.copy(isLoading = false)
            }
            return@intent
        }

        val isSuccess = sendAuthCode(phone)
        if (isSuccess) {
            router.navigateTo(Screens.ConfirmAuthCode())
        } else {
            postSideEffect(SendAuthCodeSideEffect.SendAuthError)
        }
        reduce {
            state.copy(isLoading = false)
        }
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
