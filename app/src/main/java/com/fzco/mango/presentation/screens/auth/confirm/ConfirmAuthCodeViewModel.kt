package com.fzco.mango.presentation.screens.auth.confirm

import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeSideEffect
import com.fzco.mango.presentation.screens.auth.confirm.ConfirmAuthCodeState
import javax.inject.Inject

class ConfirmAuthCodeViewModel @Inject constructor(

) : BaseViewModel<ConfirmAuthCodeState, ConfirmAuthCodeSideEffect>() {
    override val initialState = ConfirmAuthCodeState()

}
