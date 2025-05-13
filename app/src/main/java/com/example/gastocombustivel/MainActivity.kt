package com.example.gastocombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDistancia: EditText

    private lateinit var editTextAutonomia: EditText

    private lateinit var editTextPreco: EditText

    private lateinit var buttonCalcular: Button

    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        editTextDistancia = findViewById(R.id.editTextDistancia)

        editTextAutonomia = findViewById(R.id.editTextAutonomia)

        editTextPreco = findViewById(R.id.editTextPreco)

        buttonCalcular = findViewById(R.id.buttonCalcular)

        textViewResultado = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener {

            calcularGasto()

        }

        val button = findViewById<Button>(R.id.btnGoHome)
        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun calcularGasto() {

        val distanciaStr = editTextDistancia.text.toString()

        val autonomiaStr = editTextAutonomia.text.toString()

        val precoStr = editTextPreco.text.toString()

        if (distanciaStr.isBlank() || autonomiaStr.isBlank() || precoStr.isBlank()) {

            textViewResultado.text = "Por favor, preencha todos os campos."

            return

        }

        val distancia = distanciaStr.toDoubleOrNull()

        val autonomia = autonomiaStr.toDoubleOrNull()

        val preco = precoStr.toDoubleOrNull()

        if (distancia == null || autonomia == null || preco == null || autonomia == 0.0) {

            textViewResultado.text = "Valores inválidos. Verifique os dados."

            return

        }

        val gastoTotal = (distancia / autonomia) * preco

        textViewResultado.text = "Gasto total: R$ %.2f".format(gastoTotal)

    }

}
