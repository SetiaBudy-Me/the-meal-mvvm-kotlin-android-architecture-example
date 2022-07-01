package com.l3udy.themeal.view.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.l3udy.themeal.R
import com.l3udy.themeal.utils.Constants

class SplashActivity : AppCompatActivity() {
    private val tag = Constants.TAG + " " + this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(tag, Constants.TAG_LINE)
        Log.d(tag, "onCreate")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 600)
    }
}