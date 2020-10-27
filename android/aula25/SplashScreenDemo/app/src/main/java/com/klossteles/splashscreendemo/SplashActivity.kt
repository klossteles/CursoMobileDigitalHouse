package com.klossteles.splashscreendemo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView

const val DURACAO_DO_SPLASH = 4000L

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        colocarActivityFullScreen()
        setContentView(R.layout.activity_splash)
        animaTexto()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, DURACAO_DO_SPLASH)
    }

    @Suppress("DEPRECATION")
    private fun colocarActivityFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun animaTexto() {
        val appName = findViewById<TextView>(R.id.txtAppName)
        appName.alpha = 0f
        appName.y = 1000f

        appName.animate()
            .alpha(1f)
            .y(800f)
            .setDuration(1500)
            .setListener(null)

    }
}