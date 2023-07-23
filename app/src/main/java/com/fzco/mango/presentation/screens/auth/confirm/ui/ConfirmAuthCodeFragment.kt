package com.fzco.mango.presentation.screens.auth.confirm.ui

import com.fzco.mango.databinding.FragmentConfirmAuthCodeBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment
import com.fzco.mango.presentation.screens.auth.confirm.vm.ConfirmAuthCodeViewModel

class ConfirmAuthCodeFragment : MviFragment<ConfirmAuthCodeViewModel, FragmentConfirmAuthCodeBinding>(
    ConfirmAuthCodeViewModel::class,
    FragmentConfirmAuthCodeBinding::inflate
) {

}
