package com.example.web_api_anton

import android.util.Log
import androidx.lifecycle.ViewModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class AuthorizationViewModel : ViewModel() {
    fun authorizationUser(user: User, callback: (Boolean) -> Unit) {
        val jsonData = "{" +
                "\"login\": \"${user.login}\"" +
                "\"password\":\"${user.password}\"" +
                "}"

        Network.callAuthorization(jsonData).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("SERVER_TAG", "Request error.\n${e.message}")
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.w("SERVER_TAG", "Response error, code: ${response.code}, ${response.message}")
                    callback(false)
                }

                callback(true)
            }
        })
    }

    fun registerUser(user: User, callback: (Boolean) -> Unit) {
        val jsonData = "{" +
                "\"login\": \"${user.login}\"" +
                "\"password\":\"${user.password}\"" +
                "}"

        Network.callRegistration(jsonData).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("SERVER_TAG", "Request error.\n${e.message}")
                callback(false)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.w("SERVER_TAG", "Response error, code: ${response.code}, ${response.message}")
                    callback(false)
                }

                callback(true)
            }
        })
    }
}