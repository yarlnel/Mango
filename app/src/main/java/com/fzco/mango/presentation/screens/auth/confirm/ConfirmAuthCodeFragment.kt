package com.fzco.mango.presentation.screens.auth.confirm

import android.os.Bundle
import android.view.View
import com.fzco.mango.R
import com.fzco.mango.databinding.FragmentConfirmAuthCodeBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.utils.common.countryCodeToEmoji
import com.fzco.mango.presentation.utils.view.onclick
import com.fzco.mango.presentation.utils.view.showErrorConfirmationDialog
import kotlinx.coroutines.flow.collectLatest

class ConfirmAuthCodeFragment : MviFragment<ConfirmAuthCodeViewModel, FragmentConfirmAuthCodeBinding>(
    ConfirmAuthCodeViewModel::class,
    FragmentConfirmAuthCodeBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        handleState()
    }

    private fun setUpListeners() = with(binding) {
        btnConfirmAuthCode onclick {
            viewModel.confirmCode(fieldAuthCode.text.toString())
        }
    }

    private fun handleState() = observe(
        stateCollectLaunch = {
            viewModel.stateFlow.collectLatest (::render)
        },
        sideEffectCollectLaunch = {
            viewModel.sideEffectFlow.collect(::handleSideEffect)
        }
    )

    private fun render(state: ConfirmAuthCodeState) = with(state) {
        renderPhone(phone)
        renderPhoneRegion(phoneRegion)
    }

    private fun renderPhone(phone: String) {
        binding.fieldPhone.setText(phone)
    }

    private fun renderPhoneRegion(phoneRegion: String) {
        val regionEmoji = countryCodeToEmoji(phoneRegion)
        binding.btnCountry.text = regionEmoji
    }

    private fun handleSideEffect(sideEffect: ConfirmAuthCodeSideEffect) = when(sideEffect) {
        ConfirmAuthCodeSideEffect.ConfirmationError -> showErrorConfirmationDialog(
            R.string.err_confirmation_code_not_valid
        )
    }
}
