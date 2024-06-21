package com.ignacioperez.horoscapp.data

import android.util.Log
import com.ignacioperez.horoscapp.data.network.HoroscopeApiService
import com.ignacioperez.horoscapp.domain.Repository
import com.ignacioperez.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    //cuando se llame a esto, se hará la peticion a inet
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() } //Recupera modelo de data y lo transforma en modelo de domain
            .onFailure { Log.i("nacho", "Ha ocurrido un error: ${it.message}") }

        return null //si es que falla
    }
}