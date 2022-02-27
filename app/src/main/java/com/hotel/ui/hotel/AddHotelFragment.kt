package com.hotel.ui.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hotel.R
import com.hotel.databinding.FragmentAddHotelBinding
import com.hotel.model.Hotel
import com.hotel.viewmodel.HotelViewModel

class AddHotelFragment : Fragment() {
    private lateinit var hotelViewModel: HotelViewModel
    private var _binding: FragmentAddHotelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hotelViewModel =
            ViewModelProvider(this).get(HotelViewModel::class.java)

        _binding = FragmentAddHotelBinding.inflate(inflater, container, false)

        binding.btAddHotel.setOnClickListener {
            agregarHotel()
        }

        return binding.root
    }

    private fun agregarHotel() {
        val nombre = binding.etNombre.text.toString()
        if (nombre.isNotEmpty()) {
            val apellido = binding.etApellido.text.toString()
            val cedula = binding.etCedula.text.toString()
            val numeroHabitacion = binding.etNumeroHabitacion.text.toString()
            val hotel = Hotel(0,cedula,nombre,apellido,0)
            hotelViewModel.addHotel(hotel)
            Toast.makeText(requireContext(),
                getString(R.string.msg_hotel_add),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addHotelFragment_to_nav_hotel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}