package com.fzco.mango.presentation.screens.rigistration

import javax.inject.Inject

class RegistrationFieldsValidator @Inject constructor() {

    private val validationRegex = Regex("[\\da-zA-Z-_]{3,30}")

    fun isUserNameValid(username: String) : Boolean {
        val isMatches = validationRegex.matches(username)
        val isInBounds = textInBounds(username)
        return isMatches && isInBounds
    }

    fun isNameValid(name: String) : Boolean = textInBounds(name)

    private fun textInBounds(text: String) : Boolean =
        (text.length <= Constants.FieldLength.Max)
                && (text.length >= Constants.FieldLength.Min)

    object Constants {

        object FieldLength {
            const val Max = 30
            const val Min = 3
        }
    }
}