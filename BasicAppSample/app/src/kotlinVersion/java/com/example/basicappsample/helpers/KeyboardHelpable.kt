package com.example.basicappsample.helpers

import android.app.Activity
import android.view.inputmethod.InputMethodManager

interface KeyboardHelpable {
    fun Activity.hideKeyboard() {
        this.currentFocus?.let {
            val inputMethodManager =
                this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}