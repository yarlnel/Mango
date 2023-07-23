package com.fzco.mango.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect
import com.fzco.mango.presentation.common.viewmodel.contract.IState
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel <STATE: IState, SIDE_EFFECT: ISideEffect> : ViewModel(),
    IBaseViewModel<STATE, SIDE_EFFECT> {

    protected abstract val initialState: STATE

    override val container: Container<STATE, SIDE_EFFECT> by lazy {
        container(initialState)
    }

    val state get() = container.stateFlow.value
    val stateFlow get() = container.stateFlow
    val sideEffectFlow get() = container.sideEffectFlow
}
