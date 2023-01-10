package com.jkdesigns.almacenamiento_room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jkdesigns.almacenamiento_room.model.Pelicula

class PeliculasAdapter(private val mContext: Context, val listaPeliculas: List<Pelicula>)
    : ArrayAdapter<Pelicula>(mContext, 0 , listaPeliculas){

       override fun getView(indice: Int, view: View?, viewGroup: ViewGroup): View{

            val layout= LayoutInflater.from(mContext)
                .inflate(R.layout.list_item, viewGroup, false)

           val tituloPeli: TextView= layout.findViewById(R.id.tvTitulo)
           val protagonistaPeli: TextView= layout.findViewById(R.id.tvProtagonista)
           val duracionPeli: TextView= layout.findViewById(R.id.tvDuracion)

           val ubicacion= listaPeliculas[indice]

           tituloPeli.text=ubicacion.titulo
           protagonistaPeli.text=ubicacion.protagonista
           duracionPeli.text=ubicacion.duracion.toString()

           return layout


        }
}