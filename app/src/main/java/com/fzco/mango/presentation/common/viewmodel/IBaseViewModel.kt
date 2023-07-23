package com.fzco.mango.presentation.common.viewmodel

import org.orbitmvi.orbit.ContainerHost

interface IBaseViewModel<STATE: Any, SIDE_EFFECT: Any> : ContainerHost<STATE, SIDE_EFFECT>
