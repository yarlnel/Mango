package com.fzco.mango.presentation.screens.auth.send

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import com.fzco.mango.R
import com.fzco.mango.databinding.FragmentSendAuthCodeBinding
import com.fzco.mango.presentation.common.backpress.BackPressedStrategyOwner
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.utils.common.countryCodeToEmoji
import com.fzco.mango.presentation.utils.fragment.renderLoading
import com.fzco.mango.presentation.utils.view.onTextChanged
import com.fzco.mango.presentation.utils.view.onclick
import com.fzco.mango.presentation.utils.view.showErrorConfirmationDialog
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class SendAuthCodeFragment : MviFragment<SendAuthCodeViewModel, FragmentSendAuthCodeBinding>(
    viewModelClass = SendAuthCodeViewModel::class,
    bindingBlock = FragmentSendAuthCodeBinding::inflate
), BackPressedStrategyOwner {

    @Inject
    lateinit var phoneUtil: PhoneNumberUtil

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startObserve()
        setUpListeners()
    }

    private fun startObserve() = observe(
        stateCollectLaunch = {
            viewModel.stateFlow.collectLatest(::render)
        },
        sideEffectCollectLaunch = {
            viewModel.sideEffectFlow.collect(::handleSideEffect)
        }
    )

    private fun render(state: SendAuthCodeState) = with(state) {
        renderLoading(binding.loadingIndicator)
    }

    private fun handleSideEffect(sideEffect: SendAuthCodeSideEffect) = when (sideEffect) {
        SendAuthCodeSideEffect.SendAuthError -> showErrorConfirmationDialog(
            R.string.err_send_auth_code
        )
        SendAuthCodeSideEffect.InvalidPhone -> showErrorConfirmationDialog(
            R.string.err_invalid_phone
        )
    }

    private fun setUpListeners() = with(binding) {
        fieldPhone onTextChanged viewModel::updatePhone

        btnSendAuthCode onclick {
            viewModel.requestSendAuthCode(fieldPhone.text.toString())
        }

        btnCountry onclick {
            viewModel.openSelectCountryScreen()
        }

        setFragmentResultListener(FragmentsResultKey.PhoneCountryCode) { _, bundle ->
            val countryCode = bundle.getString(DataKey.CountryCode)
                ?: return@setFragmentResultListener

            viewModel.updateCountryCode(countryCode)
            setCountryEmoji(countryCode)
            setCountryMask(countryCode)
        }
    }

    private fun setCountryEmoji(countryCode: String) = with(binding) {
        btnCountry.text = countryCodeToEmoji(countryCode)
    }

    private fun setCountryMask(countryCode: String) = with(binding) {
//        val exampleNumber = phoneUtil.getExampleNumber(countryCode)
//        val formattedNumber = phoneUtil.formatNumberForMobileDialing(
//            exampleNumber,
//            countryCode,
//            true
//        )
//        val mask = formattedNumber.replace(Regex("\\d"), "_")
//
//        val phoneNumberTextWatcher = object : PhoneNumberFormattingTextWatcher(countryCode) {
//            override fun afterTextChanged(s: Editable) {
//                super.afterTextChanged(s)
//                val maskSuffix = mask.drop(s.length)
//                if (maskSuffix !in s) {
//                    s.append(maskSuffix)
//                }
//            }
//        }
        val phoneNumberTextWatcher = PhoneNumberFormattingTextWatcher(countryCode)
        val phonePrefix = phoneUtil.getCountryCodeForRegion(countryCode)
        val phonePrefixFull = getString(R.string.phone_prefix_template, phonePrefix)
        fieldPhone.setText(phonePrefixFull)
        fieldPhone.addTextChangedListener(phoneNumberTextWatcher)
        fieldPhone.setSelection(phonePrefixFull.length)
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            with(viewModel.state) {
                fieldPhone.setText(phone)
                setCountryEmoji(countryCode)
                setCountryMask(countryCode)
            }
        }
    }

    override fun handleOnBackPressed() {
        requireActivity().finish()
    }

    object FragmentsResultKey {
        const val PhoneCountryCode = "PhoneCountryCode"
    }

    object DataKey {
        const val CountryCode = "CountryCode"
    }
}
