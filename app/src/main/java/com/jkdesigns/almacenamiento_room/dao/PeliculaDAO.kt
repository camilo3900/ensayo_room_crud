package com.jkdesigns.almacenamiento_room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jkdesigns.almacenamiento_room.model.Pelicula


@Dao
interface PeliculaDAO {
    //Se consulta la lista de peliculas
    @Query("SELECT * FROM pelicula")
    fun getAll(): LiveData<List<Pelicula>>
    @Query("SELECT * FROM pelicula WHERE id=:id")
    suspend fun consultarId(id: Int)
    @Insert()
    suspend fun insertarPelicula(pelicula: Pelicula)
    @Delete
    suspend fun eliminarPelicula(pelicula:Pelicula)
    @Update
    suspend fun actualizarPelicula(pelicula:Pelicula)
}