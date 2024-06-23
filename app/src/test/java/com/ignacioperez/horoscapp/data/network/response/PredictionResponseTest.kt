package com.ignacioperez.horoscapp.data.network.response

import com.ignacioperez.horoscapp.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{

    @Test
    fun `toDomain should return a correct prediction model`(){
        //Se divide el test en 3 partes
        //Given (se da la info para el test)
        val horoscopeResponse = HoroscopeMotherObject.anyResponse

        //When (cuando algo pase)
        val predictionModel = horoscopeResponse.toDomain()

        //Then (se verifica lo que paso)
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}