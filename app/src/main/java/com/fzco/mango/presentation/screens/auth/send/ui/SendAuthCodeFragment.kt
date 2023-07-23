package com.fzco.mango.presentation.screens.auth.send.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import com.fzco.mango.R
import com.fzco.mango.databinding.FragmentSendAuthCodeBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.screens.auth.send.contract.SendAuthCodeSideEffect
import com.fzco.mango.presentation.screens.auth.send.vm.SendAuthCodeViewModel
import com.fzco.mango.presentation.utils.view.onTextChanged
import com.fzco.mango.presentation.utils.view.onclick

class SendAuthCodeFragment : MviFragment<SendAuthCodeViewModel, FragmentSendAuthCodeBinding>(
    viewModelClass = SendAuthCodeViewModel::class,
    bindingBlock = FragmentSendAuthCodeBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startObserve()
        setUpListeners()
    }

    private fun startObserve() = observe(sideEffectCollectLaunch = {
        viewModel.sideEffectFlow.collect(::handleSideEffect)
    })

    private fun handleSideEffect(sideEffect: SendAuthCodeSideEffect) = when(sideEffect) {
        SendAuthCodeSideEffect.SendAuthError -> showSendAuthError()
    }

    private fun showSendAuthError() {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.err)
            .setMessage(R.string.err_send_auth_code)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun setUpListeners() = with(binding) {
        fieldPhone onTextChanged viewModel::updatePhone
        btnSendAuthCode onclick {
            viewModel.requestSendAuthCode(fieldPhone.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        binding.fieldPhone.setText(viewModel.state.phone)
    }
}
