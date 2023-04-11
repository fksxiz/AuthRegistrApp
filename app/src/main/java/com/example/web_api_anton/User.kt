package com.example.web_api_anton

import java.io.Serializable

data class User(
    val login: String,
    val password: String
) : Serializable
