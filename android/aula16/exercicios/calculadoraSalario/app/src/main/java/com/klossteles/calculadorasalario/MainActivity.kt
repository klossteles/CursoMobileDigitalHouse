package com.klossteles.calculadorasalario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculateSalary.setOnClickListener {
            val workedHours = edtWorkedHours.text.toString().toInt()
            val hourValue = edtHourValue.text.toString().toInt()
            txtVSalary.text = getString(R.string.salary, calculateSalary(workedHours, hourValue))
            txtVSalary.visibility = View.VISIBLE
        }
    }

    private fun calculateSalary(workedHours: Int, hourValue: Int) = workedHours.times(hourValue).toDouble()
}