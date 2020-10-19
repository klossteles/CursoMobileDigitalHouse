package com.klossteles.exercicio01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager
        val aFragment = AFragment()
        val bFragment = BFragment()

        btnAdicionaFragmentoA.setOnClickListener {
            addFragment(aFragment)
        }

        btnAdicionaFragmentoB.setOnClickListener {
            addFragment(bFragment)
        }
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}