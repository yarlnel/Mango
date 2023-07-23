package com.fzco.mango.presentation.utils.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

inline fun <reified MODEL : COMMON, COMMON, VB: ViewBinding> createCommonBindingDelegate(
    noinline bindingBlock: (inflater: LayoutInflater, parent: ViewGroup, Boolean) -> VB,
    noinline block: AdapterDelegateViewBindingViewHolder<MODEL, VB>.() -> Unit
) = adapterDelegateViewBinding<MODEL, COMMON, VB>(
    viewBinding = { layoutInflater, parent ->
        bindingBlock.invoke(layoutInflater, parent, false)
    },
    block = block,
)

inline fun <reified MODEL, VB: ViewBinding> createItemBindingDelegate(
    noinline bindingBlock: (inflater: LayoutInflater, parent: ViewGroup, Boolean) -> VB,
    noinline block: AdapterDelegateViewBindingViewHolder<MODEL, VB>.() -> Unit
) = createCommonBindingDelegate<MODEL, MODEL, VB>(bindingBlock, block)
