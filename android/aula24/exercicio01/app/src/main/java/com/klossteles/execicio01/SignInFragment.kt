package com.klossteles.execicio01

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignInFragment : Fragment() {
    lateinit var mudarTabListener: IMudarTab
    private lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_sign_in, container, false)
        minhaView.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener{
            if (validaEntradas(minhaView)) {
                Toast.makeText(minhaView.context, "Login realizado", Toast.LENGTH_LONG).show()
            }
        }

        checkUsernameChanged()
        checkPasswordChanged()

        minhaView.findViewById<Button>(R.id.btnSignUpSignIn).setOnClickListener {
            mudarTabListener.mudarTab(SIGN_IN_FRAGMENT)
        }

        return minhaView
    }

    private fun checkPasswordChanged() {
        minhaView.findViewById<TextInputEditText>(R.id.edtPasswordSignIn)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    minhaView.findViewById<TextInputLayout>(R.id.txtPasswordSignIn).error = ""
                }
            })
    }

    private fun checkUsernameChanged() {
        minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignIn)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    minhaView.findViewById<TextInputLayout>(R.id.txtUsernameSignIn).error = ""
                }
            })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mudarTabListener = context as IMudarTab
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true
        val edtUsername = view.findViewById<TextInputEditText>(R.id.edtUsernameSignIn)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.edtPasswordSignIn)

        if (edtUsername.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUsernameSignIn).error = "Username vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignIn).error = "Senha vazia"
            resultado = false
        }
        return resultado
    }

    fun usernameAlterado(username: String){
        val edtUsernameSignIn = minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignIn)
        edtUsernameSignIn.setText(username)
        val edtPassword = minhaView.findViewById<TextInputEditText>(R.id.edtPasswordSignIn)
        edtPassword.requestFocus()
        edtPassword.setText("")
    }
}