package com.ignacioperez.horoscapp.ui.horoscope

import com.ignacioperez.horoscapp.data.providers.HoroscopeProvider
import com.ignacioperez.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    //copia o moquea la clase HoroscopeProvider (para no copiar o crear de nuevo la clase)
    @MockK //(relaxed = true) relaxed provee una respuesta por defecto
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var  viewModel: HoroscopeViewModel

    //se ejecuta antes del test (no para inicializar porque algun test puede cambiar el valor)
    @Before
    fun setup(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewModel is created then horoscope are loaded`(){
        //Given
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList //se asigna el valor por defecto de mokk (con corutinas usar coEvery)
        viewModel = HoroscopeViewModel(horoscopeProvider)

        //When
        val horoscopes = viewModel.horoscope.value

        //Then
        assertTrue(horoscopes.isNotEmpty())
    }

}