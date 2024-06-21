package com.ignacioperez.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.ignacioperez.horoscapp.data.providers.HoroscopeProvider
import com.ignacioperez.horoscapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) : ViewModel() {

    //trae los datos de horoscope (MVVM, el usuario puede leer horoscope pero no puede modificar _horoscope)
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //se ejecuta al inicio
    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}