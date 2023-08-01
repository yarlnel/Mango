package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.domain.usecase.user.phone.GetUserPhone
import com.fzco.mango.domain.usecase.user.phone.GetUserPhoneCountryEmoji
import com.fzco.mango.domain.usecase.user.register.RegisterUser
import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.navigation.graph.Screens
import com.github.terrakok.cicerone.Router
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class RegisterUserViewModel(
    private val getUserPhone: GetUserPhone,
    private val getUserPhoneCountryEmoji: GetUserPhoneCountryEmoji,
    private val fieldsValidator: RegistrationFieldsValidator,
    private val registerUser: RegisterUser,
    private val router: Router
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

    fun updateName(name: String) = intent {
        val isValid = fieldsValidator.isNameValid(name)
        reduce {
            state.copy(nameValid = isValid)
        }
    }

    fun updateUsername(username: String) = intent {
        val isValid = fieldsValidator.isUserNameValid(username)
        reduce {
            state.copy(usernameValid = isValid)
        }
    }

    fun register(name: String, username: String) = intent {

        reduce {
            state.copy(isLoading = true)
        }

        if (!state.nameValid || !fieldsValidator.isNameValid(name)) {
            postSideEffect(RegisterUserSideEffect.NameNotValid)
            return@intent
        }

        if (!state.usernameValid || !fieldsValidator.isUserNameValid(username)) {
            postSideEffect(RegisterUserSideEffect.UsernameNotValid)
            return@intent
        }

        val isSuccess = registerUser(
            name = name,
            username = username,
            phone = state.phone
        )

        if (isSuccess) {
            router.navigateTo(Screens.Home())
        } else {
            postSideEffect(RegisterUserSideEffect.InternalServerError)
        }

        reduce {
            state.copy(isLoading = false)
        }
    }
}