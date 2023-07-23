package com.fzco.mango.presentation.screens.auth.send.contract

import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState

data class SendAuthCodeState(
    override var isLoading: Boolean = false,
    val phone: String = ""
): ILoadingState
