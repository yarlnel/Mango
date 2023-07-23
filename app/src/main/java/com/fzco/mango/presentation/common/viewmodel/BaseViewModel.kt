package com.fzco.mango.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

abstract class BaseViewModel <STATE: Any, SIDE_EFFECT: Any> : ViewModel(),
    ContainerHost<STATE, SIDE_EFFECT>,
    IBaseViewModel {

    protected abstract val initialState: STATE
    override val container: Container<STATE, SIDE_EFFECT> get() = container(initialState)

    val state get() = container.stateFlow.value
    val stateFlow get() = container.stateFlow
    val sideEffectFlow get() = container.sideEffectFlow
}
