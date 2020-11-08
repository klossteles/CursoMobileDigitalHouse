package com.klossteles.desafioandroid.login.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
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

        onLogin(view)
        onRegister(view, navController)
        checkEmailChanged(view)
        checkPasswordChanged(view)
    }

    private fun onLogin(view: View) {
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            var success = true
            val email = view.findViewById<TextInputEditText>(R.id.edtEmailLogin)?.text.toString()
            if (email.isEmpty()) {
                view.findViewById<TextInputLayout>(R.id.txtEmailLogin).error = getString(R.string.insert_email)
                success = false
            }
            val password = view.findViewById<TextInputEditText>(R.id.edtPasswordLogin)?.text.toString()
            success = checkPassword(password, view, success)
            if (success) {
                val navController = findNavController()
                navController.navigate(R.id.action_loginFragment_to_restaurantsListFragment)
            }
        }
    }

    private fun onRegister(view: View, navController: NavController) {
        view.findViewById<Button>(R.id.btnRegisterLogin).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun checkEmailChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.edtEmailLogin)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtEmailLogin).error = ""
                }
            })
    }

    private fun checkPassword(password: String, view: View, success: Boolean): Boolean {
        var isOk = success
        if (password.isEmpty()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error =
                getString(R.string.password_cannot_be_null)
            isOk = false
        } else if (password.length < 6) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error =
                getString(R.string.must_contain_at_least_6_characters)
            isOk = false
        }
        return isOk
    }

    private fun checkPasswordChanged(view: View) {
        view.findViewById<TextInputEditText>(R.id.edtPasswordLogin)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
                    val password = view.findViewById<TextInputEditText>(R.id.edtPasswordLogin)?.text.toString()
                    checkPassword(password, view, true)
                }
            })
    }
}