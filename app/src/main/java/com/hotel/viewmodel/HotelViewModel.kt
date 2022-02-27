package com.hotel.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.hotel.data.HotelDatabase
import com.hotel.model.Hotel
import com.hotel.repository.HotelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Hotel>>
    private val repository: HotelRepository

    init {
        val hotelDao = HotelDatabase.getDatabase(application).HotelDao()
        repository = HotelRepository(hotelDao)
        getAllData = repository.getAllData
    }

     fun addHotel(hotel: Hotel) {
        viewModelScope.launch(Dispatchers.IO) {repository.addHotel(hotel)}
    }

     fun updateHotel(hotel: Hotel) {
         viewModelScope.launch(Dispatchers.IO) {repository.addHotel(hotel)}
    }

     fun deleteHotel(hotel: Hotel) {
         viewModelScope.launch(Dispatchers.IO) {repository.addHotel(hotel)}
    }
}