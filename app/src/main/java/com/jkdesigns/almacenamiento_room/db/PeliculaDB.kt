package com.jkdesigns.almacenamiento_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jkdesigns.almacenamiento_room.dao.PeliculaDAO
import com.jkdesigns.almacenamiento_room.model.Pelicula


@Database (entities=[Pelicula::class], version = 1, exportSchema = false)
abstract class PeliculaDB: RoomDatabase() {
    abstract fun peliculaDao(): PeliculaDAO

    companion object{
        private var INSTANCE: PeliculaDB?= null

        fun getDatabase(context: Context): PeliculaDB{

            val tempInstance= INSTANCE
            if (tempInstance!= null)
            {
                return  tempInstance
            }
            else{
                synchronized(this){
                    val instancia= Room.databaseBuilder(context.applicationContext, PeliculaDB::class.java, "app_database" )
                        .fallbackToDestructiveMigration().build()

                    INSTANCE= instancia
                    return instancia
                }
            }
        }
    }



}