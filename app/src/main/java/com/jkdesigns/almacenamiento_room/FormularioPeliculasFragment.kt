package com.jkdesigns.almacenamiento_room

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.room.CoroutinesRoom
import com.jkdesigns.almacenamiento_room.db.PeliculaDB
import com.jkdesigns.almacenamiento_room.model.Pelicula
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FormularioPeliculasFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmentoPeliculas =
            inflater.inflate(R.layout.fragment_formulario_peliculas, container, false)
        val titulo: EditText = fragmentoPeliculas.findViewById(R.id.edtTitulo)
        val protagonista: EditText = fragmentoPeliculas.findViewById(R.id.edtProtagonista)
        val duracion: EditText = fragmentoPeliculas.findViewById(R.id.edtDuracion)
        val AdicionarPelicula: Button = fragmentoPeliculas.findViewById(R.id.btnAdicionar)
        val Cancelar: Button = fragmentoPeliculas.findViewById(R.id.btnCancelar)

        AdicionarPelicula.setOnClickListener {
            val context = activity?.applicationContext
            val pelicula = Pelicula(
                0,
                "${titulo.text}",
                "${protagonista.text}",
                duracion.text.toString().toInt()

            )

            CoroutineScope(Dispatchers.IO).launch {
                val database = context?.let {
                    PeliculaDB.getDatabase(it)

                }
                if (database != null) {
                    database.peliculaDao().insertarPelicula(pelicula)

                }
            }
            salir()
        }
        Cancelar.setOnClickListener {
            salir()
        }
        return fragmentoPeliculas


    }

    private fun salir(){
        activity?.getSupportFragmentManager()?.beginTransaction()
            ?.remove(this)
            ?.commit()
    }


    }
