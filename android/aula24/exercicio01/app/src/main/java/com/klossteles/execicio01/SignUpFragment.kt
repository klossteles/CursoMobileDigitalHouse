package com.klossteles.execicio01

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUpFragment : Fragment() {
    private lateinit var mudarTabListener: IMudarTab
    private lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val edtUsernameSignUp = minhaView.findViewById<TextInputEditText>(R.id.edtUsernameSignUp)

        minhaView.findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {
            mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
            mudarTabListener.usernameAlterado(edtUsernameSignUp.text.toString())
        }
        return minhaView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }
}