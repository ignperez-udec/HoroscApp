package com.ignacioperez.horoscapp.motherobject

import com.ignacioperez.horoscapp.data.network.response.PredictionResponse
import com.ignacioperez.horoscapp.domain.model.HoroscopeInfo

object HoroscopeMotherObject {

    ///respuesta generica para no copiar en todos los test
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}