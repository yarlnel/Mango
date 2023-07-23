package com.fzco.mango.presentation.utils.view

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText

infix fun View.onclick(callback: () -> Unit) {
    setOnClickListener { callback.invoke() }
}

infix fun EditText.onTextChanged(callback: (text: String) -> Unit) {
    val watcher = object : TextWatcher {

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            callback.invoke(text.toString())
        }
    }
    addTextChangedListener(watcher)
}