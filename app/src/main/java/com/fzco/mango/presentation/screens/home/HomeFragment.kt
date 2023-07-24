package com.fzco.mango.presentation.screens.home

import com.fzco.mango.databinding.FragmentHomeBinding
import com.fzco.mango.presentation.common.fragments.mvi.MviFragment

class HomeFragment : MviFragment<HomeViewModel, FragmentHomeBinding>(
    viewModelClass = HomeViewModel::class,
    bindingBlock = FragmentHomeBinding::inflate
) {

}
