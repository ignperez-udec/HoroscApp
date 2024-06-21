package com.ignacioperez.horoscapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.ignacioperez.horoscapp.domain.model.PredictionModel

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel( //no necesariamente tiene que ser uno a uno, pueden ser combinaciones de datos

            horoscope = horoscope,
            sign = sign
        )
    }
}