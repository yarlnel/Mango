package com.fzco.mango.presentation.screens.auth.confirm.vm

import com.fzco.mango.presentation.common.viewmodel.BaseViewModel
import com.fzco.mango.presentation.screens.auth.confirm.contract.ConfirmAuthCodeSideEffect
import com.fzco.mango.presentation.screens.auth.confirm.contract.ConfirmAuthCodeState
import javax.inject.Inject

class ConfirmAuthCodeViewModel @Inject constructor(

) : BaseViewModel<ConfirmAuthCodeState, ConfirmAuthCodeSideEffect>() {
    override val initialState = ConfirmAuthCodeState()

}
