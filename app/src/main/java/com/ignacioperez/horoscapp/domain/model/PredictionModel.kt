package com.ignacioperez.horoscapp.domain.model

//igual que modelo PredictionResponse, pero del domain (sin bibliotecas)
data class PredictionModel(
    val horoscope: String,
    val sign: String
)
