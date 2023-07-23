package com.fzco.mango.presentation.common.viewmodel.loading

import com.fzco.mango.presentation.common.viewmodel.contract.IState

interface ILoadingState : IState {

    var isLoading: Boolean
}
