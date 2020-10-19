package com.klossteles.exercicio02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_b.view.*

class BFragment : Fragment() {
    private lateinit var fragmentBView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBView = inflater.inflate(R.layout.fragment_b, container, false)
        return fragmentBView
    }

    fun changeText(text: String) {
        fragmentBView.txtFragmentB.text = text
    }
}