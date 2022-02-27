package com.hotel.repository

import androidx.lifecycle.LiveData
import com.hotel.data.HotelDao
import com.hotel.model.Hotel

class HotelRepository(private val hotelDao: HotelDao) {
    val getAllData: LiveData<List<Hotel>> = hotelDao.getAllData()

    suspend fun addHotel(hotel: Hotel) {
        hotelDao.addHotel(hotel)
    }

    suspend fun updateHotel(hotel: Hotel) {
        hotelDao.updateHotel(hotel)
    }

    suspend fun deleteHotel(hotel: Hotel) {
        hotelDao.deleteHotel(hotel)
    }
}