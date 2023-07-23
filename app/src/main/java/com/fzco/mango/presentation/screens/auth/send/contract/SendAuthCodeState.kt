package com.fzco.mango.presentation.screens.auth.send.contract

import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState

data class SendAuthCodeState(
    override var isLoading: Boolean = false,
    val countryCode: String = "RU",
    val phone: String = ""
): ILoadingState
