package com.klossteles.desafioandroid.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.klossteles.desafioandroid.R

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {

        }

        view.findViewById<Button>(R.id.btnRegisterLogin).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}