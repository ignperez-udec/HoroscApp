package com.ignacioperez.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ignacioperez.horoscapp.databinding.FragmentHoroscopeBinding
import com.ignacioperez.horoscapp.domain.model.HoroscopeInfo
import com.ignacioperez.horoscapp.domain.model.HoroscopeModel
import com.ignacioperez.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //conecta fragment a viewModel
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    //binding en fragment (no es view)
    //_ al inicio del nombre significa privado
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    //se ejecuta para crear la view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //se ejecuta una vez la lista esta creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            //determina que tipo de objeto se llevará
            val type = when(it){
                HoroscopeInfo.Aquarius -> HoroscopeModel.Aquarius
                HoroscopeInfo.Aries -> HoroscopeModel.Aries
                HoroscopeInfo.Cancer -> HoroscopeModel.Cancer
                HoroscopeInfo.Capricorn -> HoroscopeModel.Capricorn
                HoroscopeInfo.Gemini -> HoroscopeModel.Gemini
                HoroscopeInfo.Leo -> HoroscopeModel.Leo
                HoroscopeInfo.Libra -> HoroscopeModel.Libra
                HoroscopeInfo.Pisces -> HoroscopeModel.Pisces
                HoroscopeInfo.Sagittarius -> HoroscopeModel.Sagittarius
                HoroscopeInfo.Scorpio -> HoroscopeModel.Scorpio
                HoroscopeInfo.Taurus -> HoroscopeModel.Taurus
                HoroscopeInfo.Virgo -> HoroscopeModel.Virgo
            }

            //navega a nueva pantalla
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })

        //es lo mismo que lo comentado (para no colocar lo mismo dos veces)
        binding.rvHoroscope.apply {
            //imprime lineal
            //layoutManager = LinearLayoutManager(context)
            //imprime en columnas
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
        //binding.rvHoroscope.layoutManager = LinearLayoutManager(context)
        //binding.rvHoroscope.adapter = adapter
    }

    private fun initUIState() {
        //crea corrutina liga al fragment, si este muere, el hilo igual muere
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    //cambios en horoscope
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

}