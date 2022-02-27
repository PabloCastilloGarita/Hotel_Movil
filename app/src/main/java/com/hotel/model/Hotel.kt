package com.hotel.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "hotel")
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "cedula")
    val cedula: String,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "apellido")
    val apellido: String,
    @ColumnInfo(name = "numeroHabitacion")
    val numeroHabitacion: Int,
) : Parcelable
