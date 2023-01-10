package com.jkdesigns.almacenamiento_room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "pelicula")
data class Pelicula(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titulo: String,
    val protagonista: String,
    val duracion: Int,
)
