package com.klossteles.aula41

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

import com.klossteles.aula41.R

class LoginActivity : AppCompatActivity() {

    private lateinit var _view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        onLogIn()
        findViewById<CheckBox>(R.id.chkKeepLogin).setOnCheckedChangeListener{ _, isChecked ->
            val pref = this.getSharedPreferences(MainActivity.AULA_41, Context.MODE_PRIVATE)
            pref.edit().putBoolean(MainActivity.KEEP_LOGGED, isChecked).apply()
        }
    }

    private fun onLogIn() {
        findViewById<Button>(R.id.login).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}