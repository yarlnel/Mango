package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.domain.usecase.user.phone.GetUserPhone
import com.fzco.mango.domain.usecase.user.phone.GetUserPhoneCountryEmoji
import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class RegisterUserViewModel(
    private val getUserPhone: GetUserPhone,
    private val getUserPhoneCountryEmoji: GetUserPhoneCountryEmoji,

) : BaseViewModel<RegisterUserState, RegisterUserSideEffect>() {

    override val initialState = RegisterUserState()

    init {
        loadData()
    }

    private fun loadData() = intent {
        val phone = getUserPhone()
        val phoneCountryEmoji = getUserPhoneCountryEmoji()
        reduce {
            state.copy(
                phone = phone,
                phoneCountryEmoji = phoneCountryEmoji
            )
        }
    }

    fun registerUser(name: String, username: String) {

    }
}