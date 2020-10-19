package com.klossteles.exercicio02

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.view.*

class AFragment : Fragment() {
    private lateinit var iClick: IClick
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        calculateAge(view)

        return view
    }

    private fun calculateAge(view: View) {
        view.btnCalculate.setOnClickListener {
            var success = true
            val name = view.txtName.editText?.text.toString()
            if (name.isEmpty()) {
                view.txtName.editText?.error = getString(R.string.name_cannot_be_empty)
                success = false
            }

            val yearStr = view.txtYear.editText?.text.toString()
            if (yearStr.isEmpty()) {
                view.txtYear.editText?.error = getString(R.string.year_cannot_be_empty)
                success = false
            }

            if (!success) {
                return@setOnClickListener
            }
            val year = yearStr.toInt()
            iClick.click(name, year)

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iClick = context as IClick
    }
}