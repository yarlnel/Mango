package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.databinding.FragmentConfirmAuthCodeBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment

class ConfirmAuthCodeFragment : MviFragment<ConfirmAuthCodeViewModel, FragmentConfirmAuthCodeBinding>(
    ConfirmAuthCodeViewModel::class,
    FragmentConfirmAuthCodeBinding::inflate
) {

}
