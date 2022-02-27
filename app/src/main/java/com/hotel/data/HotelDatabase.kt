package com.hotel.data

import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hotel.model.Hotel

@Database(entities=[Hotel::class], version = 1, exportSchema = false)
abstract class HotelDatabase : RoomDatabase() {
    abstract fun HotelDao() : HotelDao

    companion object {
        @Volatile
        private var INSTANCE: HotelDatabase? = null

        fun getDatabase(context: android.content.Context) : HotelDatabase {
            var instance = INSTANCE
            if (instance != null) {
                return instance
            }
            synchronized(this) {
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    HotelDatabase::class.java,
                    "hotel_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }
    }
}