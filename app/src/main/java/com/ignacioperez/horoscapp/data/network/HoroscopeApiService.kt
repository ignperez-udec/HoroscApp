package com.ignacioperez.horoscapp.data.network

import com.ignacioperez.horoscapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse

}