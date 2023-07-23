package com.fzco.mango.presentation.utils.viewmodel.loading

import com.fzco.mango.presentation.common.viewmodel.IBaseViewModel
import com.fzco.mango.presentation.common.viewmodel.contract.ISideEffect
import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

fun <STATE: ILoadingState, SIDE_EFFECT: ISideEffect>
        IBaseViewModel<STATE, SIDE_EFFECT>.intentLoading(
    transformer: suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit
) = intent {
    reduce {
        state.apply { isLoading = true }
    }
    transformer()
    reduce {
        state.apply { isLoading = true }
    }
}
