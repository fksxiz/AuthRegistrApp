package com.example.web_api_anton

import android.util.Patterns
import java.util.regex.Pattern

object Validator {
    fun validatePassword(password: String): Boolean {
        val specSymbols: CharArray = charArrayOf('%', '#', '_', '$', '^')

        Patterns.EMAIL_ADDRESS.matcher(S_KEM_PROVERYAEM).matches()

        return password.length in 8..20 &&
                password.any { it.isDigit() } &&
                password.any { it.isLowerCase() } &&
                password.any { it.isUpperCase() } &&
                password.any { it in specSymbols }
    }

    fun validateEmail(email: String): Boolean {
        return Pattern.compile(
            "[a-zA-Z0-9+._%\\-]{4,32}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{3,8}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,8}" +
                    ")+"
        ).matcher(email).matches()
    }
}