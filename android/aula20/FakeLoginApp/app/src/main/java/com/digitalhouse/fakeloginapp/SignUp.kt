package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
//    private val edtNameSignUp by lazy { findViewById<EditText>(R.id.edtNameSignUp) }
//    private val edtEmailSignUp by lazy { findViewById<EditText>(R.id.edtEmailSignUp) }
//    private val edtPasswordSignUp by lazy { findViewById<EditText>(R.id.edtPasswordSignUp) }
    private val ckPrivacyPolicy by lazy { findViewById<CheckBox>(R.id.ckPrivacyPolicy) }
    private val btnSignUpUser by lazy { findViewById<Button>(R.id.btnSignUpUser) }
    private val btnLogInSignUp by lazy { findViewById<Button>(R.id.btnLogInSignUp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        logIn()
        checkPrivacyPolicy()
        signUpUser()
    }

    private fun logIn() {
        btnLogInSignUp.setOnClickListener {
            finish()
        }
    }

    private fun checkPrivacyPolicy() {
        ckPrivacyPolicy.setOnCheckedChangeListener { _, isChecked ->
            btnSignUpUser.isEnabled = isChecked
        }
    }

    private fun signUpUser() {
        btnSignUpUser.setOnClickListener {
            var success = true
            val name = edtNameSignUp.editText?.text.toString()
            if (name.isEmpty()) {
                edtNameSignUp.error = getString(R.string.insert_name)
                success = false
            }
            val email = edtEmailSignUp.editText?.text.toString()
            if (email.isEmpty()) {
                edtEmailSignUp.error = getString(R.string.insert_email)
                success = false
            }
            val password = edtPasswordSignUp.editText?.text.toString()
            if (password.isEmpty()) {
                edtPasswordSignUp.error = getString(R.string.insert_password)
                success = false
            }

            if (!success) return@setOnClickListener

            try {
                UserService.register(name, email, password)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, getString(R.string.user_registered), Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}