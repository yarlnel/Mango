package com.fzco.mango.presentation.common.fragments.mvi

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.fzco.mango.presentation.common.fragments.base.BaseFragment
import com.fzco.mango.presentation.common.fragments.base.BindingInflationBlock
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KClass
import javax.inject.Inject

abstract class MviFragment<VM : ViewModel, VB : ViewBinding>(
    private val viewModelClass: KClass<VM>,
    bindingBlock: BindingInflationBlock<VB>
) : BaseFragment<VB>(bindingBlock) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val viewModel get() = viewModelFactory.create(viewModelClass.java)

    protected fun observe(
        stateCollectLaunch: (suspend CoroutineScope.() -> Unit)? = null,
        sideEffectCollectLaunch: (suspend CoroutineScope.() -> Unit)? = null
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                if (stateCollectLaunch != null) launch {
                    stateCollectLaunch()
                }
                if (sideEffectCollectLaunch != null) launch {
                    sideEffectCollectLaunch()
                }
            }
        }
    }
}