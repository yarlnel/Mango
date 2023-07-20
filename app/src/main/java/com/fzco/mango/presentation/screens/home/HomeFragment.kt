package com.fzco.mango.presentation.screens.home

import android.os.Bundle
import android.view.View
import com.fzco.mango.databinding.FragmentHomeBinding
import com.fzco.mango.presentation.common.fragments.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}