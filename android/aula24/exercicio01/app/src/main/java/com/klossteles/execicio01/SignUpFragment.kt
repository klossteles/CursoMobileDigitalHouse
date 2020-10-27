package com.klossteles.execicio01

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {
    private lateinit var mudarTabListener: IMudarTab
    private lateinit var minhaView: View
    private lateinit var chkIAgree: CheckBox
    private lateinit var btnSignUp: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val edtUsernameSignUp = minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignUp)
        chkIAgree = minhaView.findViewById<CheckBox>(R.id.chkIAgree)
        btnSignUp = minhaView.findViewById<MaterialButton>(R.id.btnSignUp)

        checkIAgree()
        onClickSignUp(edtUsernameSignUp)
        checkUsernameChanged()
        checkPasswordChanged()
        checkRepeatPasswordChanged()

        return minhaView
    }

    private fun onClickSignUp(edtUsernameSignUp: TextInputEditText) {
        minhaView.findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {
            if (validaEntradas(minhaView)) {
                mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
                mudarTabListener.usernameAlterado(edtUsernameSignUp.text.toString())
                minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignUp).setText("")
                minhaView.findViewById<TextInputEditText>(R.id.edtPasswordSignUp).setText("")
                minhaView.findViewById<TextInputEditText>(R.id.edtRepeatPasswordSignUp).setText("")
                Toast.makeText(minhaView.context, "Username cadastrado", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkUsernameChanged() {
        minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length!! < 8) {
                        minhaView.findViewById<TextInputLayout>(R.id.txtUsernameSignUp).error = "Mínimo de caracteres 8"
                        return
                    }
                    minhaView.findViewById<TextInputLayout>(R.id.txtUsernameSignUp).error = ""
                }
            })
    }

    private fun checkPasswordChanged() {
        minhaView.findViewById<TextInputEditText>(R.id.edtPasswordSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length!! < 8) {
                        minhaView.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Mínimo de caracteres 8"
                        return
                    }
                    minhaView.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = ""
                }
            })
    }

    private fun checkRepeatPasswordChanged() {
        minhaView.findViewById<TextInputEditText>(R.id.edtRepeatPasswordSignUp)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) { }

                override fun beforeTextChanged( s: CharSequence?, start: Int, count: Int, after: Int ) { }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length!! < 8) {
                        minhaView.findViewById<TextInputLayout>(R.id.txtPasswordRepeatSignUp).error = "Mínimo de caracteres 8"
                        return
                    }
                    minhaView.findViewById<TextInputLayout>(R.id.txtPasswordRepeatSignUp).error = ""
                }
            })
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true
        val edtUsername = view.findViewById<TextInputEditText>(R.id.edtUsernameSignUp)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.edtPasswordSignUp)
        val edtRepeatPassword = view.findViewById<TextInputEditText>(R.id.edtRepeatPasswordSignUp)

        if (edtUsername.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUsernameSignUp).error = "Username vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignUp).error = "Senha vazia"
            resultado = false
        }

        if (edtRepeatPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordRepeatSignUp).error = "Senha vazia"
            resultado = false
        }

        if (!edtRepeatPassword.text?.toString().equals(edtPassword?.text.toString())) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordRepeatSignUp).error = "Senhas devem ser iguais"
            resultado = false
        }

        return resultado
    }

    private fun checkIAgree() {
        chkIAgree.setOnCheckedChangeListener { _, isChecked ->
            btnSignUp.isEnabled = isChecked
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }
}