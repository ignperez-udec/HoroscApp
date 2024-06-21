package com.ignacioperez.horoscapp.domain

import com.ignacioperez.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sing: String): PredictionModel?
}