package com.fzco.mango.presentation.utils.fragment

import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState

fun <STATE: ILoadingState> STATE.renderLoading(loadingIndicator: ProgressBar) {
    loadingIndicator.isVisible = isLoading
}
