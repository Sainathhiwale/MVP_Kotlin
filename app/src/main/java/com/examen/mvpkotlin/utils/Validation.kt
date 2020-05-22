package com.examen.kotlinretrofit.utils

import android.widget.EditText

object Validation {
    val MSG ="can not be empty"

    fun hasText(editText: EditText):Boolean{
        var text = editText.text.toString()
        editText.setError(null)
        editText.setFocusable(true)
        if (text.length == 0){
          editText.setError(MSG)
            return false
        }
        return true

    }
}