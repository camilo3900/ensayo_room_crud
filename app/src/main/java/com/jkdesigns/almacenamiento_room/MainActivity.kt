package com.jkdesigns.almacenamiento_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.lifecycle.Observer
import com.jkdesigns.almacenamiento_room.db.PeliculaDB
import com.jkdesigns.almacenamiento_room.model.Pelicula

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database= PeliculaDB.getDatabase(this)
        var listaPeliculas= emptyList<Pelicula>()
        val Adicionar: Button= findViewById(R.id.btnAdicionar)

        database.peliculaDao().getAll().observe(this, Observer {
            listaPeliculas=it

            val ADAPTADOR= PeliculasAdapter(this, listaPeliculas)

            val listViewPeliculas: ListView= findViewById(R.id.lvPeliculas)

            listViewPeliculas.adapter= ADAPTADOR

        })


        Adicionar.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragmentos, FormularioPeliculasFragment::class.java, null, "Formulario")
                .commit()
        }

    }




}