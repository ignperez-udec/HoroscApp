package com.ignacioperez.horoscapp.data.providers

import com.ignacioperez.horoscapp.domain.model.HoroscopeInfo
import com.ignacioperez.horoscapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

//no se pasan cosas entre capas, asi que se usa daggerHilt para inyectar dependencias (data pasa a ui)
class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo>{
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}