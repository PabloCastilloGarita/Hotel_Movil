package com.hotel.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hotel.model.Hotel

@Dao
interface HotelDao {
    @Query ("select * from HOTEL")
    fun getAllData() : LiveData<List<Hotel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHotel(hotel: Hotel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateHotel(hotel: Hotel)

    @Delete
    suspend fun deleteHotel(hotel: Hotel)
}