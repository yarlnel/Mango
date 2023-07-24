package com.fzco.mango.presentation.screens.home

import com.fzco.mango.presentation.common.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel<HomeState, HomeSideEffect>() {

    override val initialState = HomeState()

}