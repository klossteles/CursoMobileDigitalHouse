package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService

class MainActivity : AppCompatActivity() {
    private val btnSignUp by lazy { findViewById<Button>(R.id.btnSignUp) }
    private val btnLogIn by lazy { findViewById<Button>(R.id.btnLogIn) }
    private val edtEmail by lazy { findViewById<EditText>(R.id.edtEmail) }
    private val edtPassword by lazy { findViewById<EditText>(R.id.edtPassword) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newUser()
        logIn()
    }

    private fun newUser() {
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun logIn() {
        btnLogIn.setOnClickListener {
            var success = true
            val email = edtEmail.text.toString()
            if (email.isEmpty()) {
                edtEmail.error = getString(R.string.insert_email)
                success = false
            }

            val password = edtPassword.text.toString()
            if (password.isEmpty()) {
                edtEmail.error = getString(R.string.insert_password)
                success = false
            }

            if (!success) {
                return@setOnClickListener
            }

            val user = UserService.logIn(email, password)
            if (user == null) {
                Toast.makeText(this, getString(R.string.user_not_found), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, Welcome::class.java)
            intent.putExtra("NAME", user.name)
            startActivity(intent)
        }
    }
}