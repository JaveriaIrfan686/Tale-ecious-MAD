package com.example.taleecious

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.core.os.postDelayed

class frontPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        Handler(Looper.getMainLooper()).postDelayed(2000) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        Handler(Looper.getMainLooper()).postDelayed(2000) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
   










    }
}