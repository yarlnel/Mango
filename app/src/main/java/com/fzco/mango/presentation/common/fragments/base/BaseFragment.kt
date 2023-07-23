package com.fzco.mango.presentation.common.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

typealias BindingInflationBlock<VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB

abstract class BaseFragment<VB : ViewBinding> constructor(
    private val bindingBlock: BindingInflationBlock<VB>
) : DaggerFragment() {

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewBinding = bindingBlock(inflater, container, false)
        this.binding = viewBinding

        return viewBinding.root
    }

    protected fun performOnBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    protected fun toast(text: String, isDurationLong: Boolean = false) {
        val durationStrategy = if (isDurationLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(requireContext(), text, durationStrategy).show()
    }
}
