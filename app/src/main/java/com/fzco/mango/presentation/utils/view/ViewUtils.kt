package com.fzco.mango.presentation.utils.view

import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.fzco.mango.R

infix fun View.onclick(callback: () -> Unit) {
    setOnClickListener { callback.invoke() }
}

infix fun TextView.onTextChanged(callback: (text: String) -> Unit) {
    val watcher = object : TextWatcher {

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {}
        override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
            callback.invoke(text.toString())
        }
    }
    addTextChangedListener(watcher)
}

fun Fragment.showErrorConfirmationDialog(@StringRes id: Int) {
    val message = getString(id)
    showErrorConfirmationDialog(message)
}

fun Fragment.showErrorConfirmationDialog(message: String) {
    AlertDialog.Builder(requireContext())
        .setTitle(R.string.err)
        .setMessage(message)
        .setPositiveButton(R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }.show()
}