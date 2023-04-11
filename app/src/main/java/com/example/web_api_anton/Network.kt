package com.example.web_api_anton

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

object Network {
    private const val scheme = "http"
    private const val host = "192.168.47.1"

    private const val url = "http://192.168.47.1:12552/register"

    private val client = OkHttpClient()

    // json to request body with media type...
    private val dataToRequestBody: (String) -> RequestBody =
        { it.toRequestBody("application/json; charset=utf-8".toMediaType()) }

    fun callAuthorization(data: String): Call {
        return client.newCall(
            Request.Builder()
                .post(dataToRequestBody(data))
                .url(
                    HttpUrl.Builder()
                        .scheme(scheme)
                        .host(host)
                        .port(12552)
                        .addPathSegment("authorization")
                        .build()
                )
                .build()
        )
    }

    fun callRegistration(data: String): Call {
        return client.newCall(
            Request.Builder()
                .post(dataToRequestBody(data))
                .url(
                    HttpUrl.Builder()
                        .scheme(scheme)
                        .host(host)
                        .port(12552)
                        .addPathSegment("register")
                        .build()
                )
                .build()
        )
    }
}