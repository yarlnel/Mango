package com.fzco.mango.presentation.utils.fragment

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.fzco.mango.presentation.common.viewmodel.loading.ILoadingState
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <STATE: ILoadingState> STATE.renderLoading(loadingIndicator: ProgressBar) {
    loadingIndicator.isVisible = isLoading
}
