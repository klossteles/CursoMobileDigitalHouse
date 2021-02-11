package com.klossteles.exercicio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.*

class MainActivity : AppCompatActivity(), IClick {
    private val fragmentB = BFragment()
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = AFragment()
        addFragment(fragmentA, R.id.containerFragmentA)
        addFragment(fragmentB, R.id.containerFragmentB)
    }

    override fun click(name: String, birthYear: Int) {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        if (currentYear.compareTo(birthYear) < 0) {
            fragmentB.changeText(getString(R.string.ainda_nao_nasceu, name))
        } else {
            val age = currentYear.minus(birthYear.toInt())
            val text = resources.getQuantityString(R.plurals.nameAndYear, age, age, name);
                fragmentB.changeText(text)
        }
    }

    private fun addFragment(fragment: Fragment, container: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(container, fragment)
        transaction.commit()
    }
}