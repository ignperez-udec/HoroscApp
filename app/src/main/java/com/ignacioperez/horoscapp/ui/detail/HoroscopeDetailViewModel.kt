package com.ignacioperez.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ignacioperez.horoscapp.domain.model.HoroscopeModel
import com.ignacioperez.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    //carga estado inicial loading
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeModel

    //si se usa mucha logica en un mismo hilo, se puede lagear (usar dispatchers.io para pasar a otro hilo)
    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            //hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result =
                withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } //hilo secundario
            //hilo principal
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error, intentelo más tarde") //más avanza es devolver el error
            }
        }
    }
}