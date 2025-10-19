package com.example.parcialjuegocolores

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIniciarJuego = view.findViewById<Button>(R.id.btnIniciar)
        val btnReglas = view.findViewById<Button>(R.id.btnReglas)

        // ✅ Botón para mostrar las reglas del juego
        btnReglas.setOnClickListener {
            mostrarReglas()
        }

        //Botón para iniciar el juego
        btnIniciarJuego.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_gameFragment)
        }
    }

    private fun mostrarReglas() {
        AlertDialog.Builder(requireContext())
            .setTitle("Reglas del Juego de Colores")
            .setMessage(getString(R.string.reglas_juego))

            .setPositiveButton("Entendido") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}