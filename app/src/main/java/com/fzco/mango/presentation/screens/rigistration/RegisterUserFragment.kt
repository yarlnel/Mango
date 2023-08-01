package com.fzco.mango.presentation.screens.rigistration

import android.os.Bundle
import android.view.View
import com.fzco.mango.R
import com.fzco.mango.databinding.FragmentRegistrationBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.utils.view.onTextChanged
import com.fzco.mango.presentation.utils.view.onclick
import com.fzco.mango.presentation.utils.view.showErrorConfirmationDialog
import kotlinx.coroutines.flow.collectLatest

class RegisterUserFragment : MviFragment<RegisterUserViewModel, FragmentRegistrationBinding>(
    viewModelClass = RegisterUserViewModel::class,
    bindingBlock = FragmentRegistrationBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        handleState()
    }

    private fun setUpListeners() = with(binding) {
        btnRegistration onclick {
            viewModel.register(
                name = fieldName.text.toString(),
                username = fieldUsername.text.toString()
            )
        }

        fieldName onTextChanged viewModel::updateName
        fieldUsername onTextChanged viewModel::updateUsername
    }

    private fun handleState() = observe(
        stateCollectLaunch = {
            viewModel.stateFlow.collectLatest(::render)
        },
        sideEffectCollectLaunch = {
            viewModel.sideEffectFlow.collect(::handleSideEffect)
        }
    )

    private fun handleSideEffect(sideEffect: RegisterUserSideEffect) = when(sideEffect) {
        RegisterUserSideEffect.UsernameNotValid -> showErrorConfirmationDialog(
            R.string.err_username_not_valid_message
        )
        RegisterUserSideEffect.NameNotValid -> showErrorConfirmationDialog(
            R.string.err_name_not_valid_message
        )
        RegisterUserSideEffect.InternalServerError -> showErrorConfirmationDialog(
            R.string.err_registration_internal
        )
    }

    private fun render(state: RegisterUserState) = with(state) {
        renderPhoneCountryEmoji(phoneCountryEmoji)
        renderPhone(phone)
        renderNameValidation(nameValid)
        renderUsernameValidation(usernameValid)
    }

    private fun renderPhoneCountryEmoji(phoneCountryEmoji: String) {
        binding.btnCountry.text = phoneCountryEmoji
    }

    private fun renderPhone(phone: String) {
        binding.fieldPhone.setText(phone)
    }

    private fun renderNameValidation(
        isNameValid: Boolean
    ) = with(binding.containerFieldName) {
        error = if (isNameValid) getString(R.string.err_name_field_validation) else ""
    }

    private fun renderUsernameValidation(
        isUsernameValid: Boolean
    ) = with(binding.containerFieldUsername) {
        error = if (isUsernameValid) getString(R.string.err_username_validation) else ""
    }
}
