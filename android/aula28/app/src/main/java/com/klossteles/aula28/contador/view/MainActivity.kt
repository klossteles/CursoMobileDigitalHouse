package com.klossteles.aula28.contador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.klossteles.aula28.R
import com.klossteles.aula28.contador.viewmodel.ContadorViewModel
import com.klossteles.aula28.contador.viewmodel.ContadorViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var _viewModel: ContadorViewModel

    private val _texto by lazy { findViewById<TextView>(R.id.txtContagem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupUI()
    }

    private fun setupViewModel() {
        _viewModel = ViewModelProvider(
            this,
            ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)

        _viewModel.contador.observe(this, alterarTexto)
    }

    private val alterarTexto = Observer<Int> {
        _texto.text = it.toString()
    }

    private fun setupUI() {
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            _viewModel.incrementar()
        }
    }

    override fun onStart() {
        Log.i(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    companion object {
        const val TAG = "MAIN_ACTIVITY"
    }
}