package com.example.parcialjuegocolores

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment(R.layout.fragment_game) {

    private lateinit var vColor: View
    private lateinit var tvPuntaje: TextView
    private lateinit var tvTiempo: TextView
    private lateinit var timer: CountDownTimer

    private var puntaje = 0
    private var tiempoRestante = 30
    private var colorActual = ""

    private val colores = mapOf(
        "Rojo" to 0xFFF44336.toInt(),
        "Verde" to 0xFF4CAF50.toInt(),
        "Azul" to 0xFF2196F3.toInt(),
        "Amarillo" to 0xFFFFEB3B.toInt()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vColor = view.findViewById(R.id.vColor)
        tvPuntaje = view.findViewById(R.id.tvPuntaje)
        tvTiempo = view.findViewById(R.id.tvTiempo)

        // Botones de colores
        val btnRojo = view.findViewById<Button>(R.id.btnRojo)
        val btnVerde = view.findViewById<Button>(R.id.btnVerde)
        val btnAzul = view.findViewById<Button>(R.id.btnAzul)
        val btnAmarillo = view.findViewById<Button>(R.id.btnAmarillo)

        val botones = listOf(btnRojo, btnVerde, btnAzul, btnAmarillo)

        botones.forEach { boton ->
            boton.setOnClickListener { verificarColor(boton.text.toString()) }
        }

        generarNuevoColor()
        iniciarTemporizador()
    }

    private fun generarNuevoColor() {
        val colorAleatorio = colores.keys.random()
        colorActual = colorAleatorio
        vColor.setBackgroundColor(colores[colorAleatorio]!!)
    }

    private fun verificarColor(colorSeleccionado: String) {
        if (colorSeleccionado == colorActual) {
            puntaje++
            tvPuntaje.text = "Puntaje: $puntaje"
            Toast.makeText(requireContext(), "¡Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Incorrecto 😅", Toast.LENGTH_SHORT).show()
        }
        generarNuevoColor()
    }

    private fun iniciarTemporizador() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = (millisUntilFinished / 1000).toInt()
                tvTiempo.text = "Tiempo: ${tiempoRestante}s"
            }

            override fun onFinish() {
                // Pasar el puntaje al fragmento de resultados
                val bundle = Bundle()
                bundle.putInt("puntajeFinal", puntaje)
                findNavController().navigate(R.id.action_gameFragment_to_resultFragment, bundle)
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}
