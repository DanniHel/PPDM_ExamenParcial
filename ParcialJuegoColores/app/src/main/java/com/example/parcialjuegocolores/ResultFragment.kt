package com.example.parcialjuegocolores

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var tvPuntajeFinal: TextView
    private lateinit var tvPuntajeMaximo: TextView
    private lateinit var rvHistorial: RecyclerView
    private lateinit var btnVolver: Button

    companion object {
        // ✅ Lista en memoria para almacenar historial de la sesión
        private val historialPuntajes = mutableListOf<Int>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPuntajeFinal = view.findViewById(R.id.tvPuntajeFinal)
        tvPuntajeMaximo = view.findViewById(R.id.tvPuntajeMaximo)
        rvHistorial = view.findViewById(R.id.rvHistorial)
        btnVolver = view.findViewById(R.id.btnVolver)

        // ✅ Obtener el puntaje final desde argumentos
        val puntajeFinal = arguments?.getInt("puntajeFinal") ?: 0

        // ✅ Mostrar puntaje final
        tvPuntajeFinal.text = "Puntaje final: $puntajeFinal"

        // ✅ Guardar puntaje en historial de sesión
        historialPuntajes.add(0, puntajeFinal) // lo más reciente primero

        // ✅ Configurar RecyclerView
        rvHistorial.layoutManager = LinearLayoutManager(requireContext())
        rvHistorial.adapter = HistorialAdapter(historialPuntajes)

        // ✅ Manejar SharedPreferences para puntaje más alto
        val prefs = requireActivity().getSharedPreferences("JuegoColoresPrefs", Context.MODE_PRIVATE)
        val puntajeMaximo = prefs.getInt("puntajeMaximo", 0)

        if (puntajeFinal > puntajeMaximo) {
            prefs.edit().putInt("puntajeMaximo", puntajeFinal).apply()
            tvPuntajeMaximo.text = "Nuevo récord 🎉: $puntajeFinal"
        } else {
            tvPuntajeMaximo.text = "Puntaje más alto: $puntajeMaximo"
        }

        // ✅ Botón volver a jugar
        btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_welcomeFragment)
        }
    }

    // ========================
    // ADAPTADOR DEL HISTORIAL
    // ========================
    class HistorialAdapter(private val puntajes: List<Int>) :
        RecyclerView.Adapter<HistorialAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvItem: TextView = view.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val puntaje = puntajes[position]
            holder.tvItem.text = "Partida ${position + 1}: $puntaje puntos"
        }

        override fun getItemCount(): Int = puntajes.size
    }
}
