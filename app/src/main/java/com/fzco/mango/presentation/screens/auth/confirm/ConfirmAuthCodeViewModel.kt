package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.domain.models.auth.AuthConfirmationInfo
import com.fzco.mango.domain.usecase.auth.ConfirmAuthCode
import com.fzco.mango.domain.usecase.user.phone.GetUserPhone
import com.fzco.mango.domain.usecase.user.phone.GetUserPhoneRegionCode
import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.navigation.graph.Screens
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeSideEffect
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeState
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import javax.inject.Inject

class ConfirmAuthCodeViewModel @Inject constructor(
    private val confirmAuthCode: ConfirmAuthCode,
    private val getUserPhone: GetUserPhone,
    private val getUserPhoneRegionCode: GetUserPhoneRegionCode,
    private val router: Router
) : BaseViewModel<ConfirmAuthCodeState, ConfirmAuthCodeSideEffect>() {
    override val initialState = ConfirmAuthCodeState()

    init {
        loadData()
    }

    private fun loadData() = intent {
        val phone = getUserPhone()
        val countryCode = getUserPhoneRegionCode()
        reduce {
            state.copy(
                phone = phone,
                phoneRegion = countryCode
            )
        }
    }

    fun confirmCode(authCode: String) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        val confirmationInfo = confirmAuthCode(state.phone, authCode)
        if (confirmationInfo is AuthConfirmationInfo.Error) {
            postSideEffect(ConfirmAuthCodeSideEffect.ConfirmationError)
            return@intent
        }

        if (confirmationInfo !is AuthConfirmationInfo.Result) return@intent
        reduce {
            state.copy(isLoading = false)
        }

        if (confirmationInfo.isUserExists) {
            router.navigateTo(Screens.Home())
        } else {
            router.navigateTo(Screens.RegisterUser())
        }
    }
}
