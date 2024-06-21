package com.ignacioperez.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().header("Autorization", "key_secreta").build() //la clave se debe recuperar de otra clase
        return chain.proceed(request)
    }
}