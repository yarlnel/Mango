package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState

data class ConfirmAuthCodeState(
    override var isLoading: Boolean = false,
    val phone: String = "",
    val phoneRegion: String = ""
) : ILoadingState
