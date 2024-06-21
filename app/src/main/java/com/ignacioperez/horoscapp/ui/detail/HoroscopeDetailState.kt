package com.ignacioperez.horoscapp.ui.detail

import com.ignacioperez.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    //cuando se pasan parametros usar data class, sino usar data object (cuando es simple)
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel) : HoroscopeDetailState()
}