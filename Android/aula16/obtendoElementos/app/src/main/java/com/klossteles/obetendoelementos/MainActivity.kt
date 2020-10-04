package com.klossteles.obetendoelementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowResult.setOnClickListener {
            val num = edtNumber.text.toString().toInt()

            if (isOdd(num)) {
                txtResult.text = getString(R.string.message_odd, num)
            } else {
                txtResult.text = getString(R.string.message_even, num.toFloat())
            }
        }
    }

    private fun isOdd(num: Int): Boolean {
        return num % 2 == 0
    }
}