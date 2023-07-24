package com.fzco.mango.presentation.screens.rigistration

import com.fzco.mango.databinding.FragmentRegistrationBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment

class RegisterUserFragment : MviFragment<RegisterUserViewModel, FragmentRegistrationBinding>(
    viewModelClass = RegisterUserViewModel::class,
    bindingBlock = FragmentRegistrationBinding::inflate
) {


}
