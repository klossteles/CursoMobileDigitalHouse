package com.klossteles.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConvert.setOnClickListener {
            val temperature = edtTemperature.text.toString().toInt()
            val convertedTemperature = convertCelsiusToFahrenheit(temperature)
            txtVTemperatureConverted.text = getString(R.string.temperature_converted, convertedTemperature)
            txtVTemperatureConverted.visibility = View.VISIBLE
        }
    }

    private fun convertCelsiusToFahrenheit(temperature: Int): Int {
        return  ((temperature * 9) / 5) + 32
    }
}