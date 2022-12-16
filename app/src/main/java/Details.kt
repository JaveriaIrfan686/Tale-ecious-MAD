package com.example.taleecious
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taleecious.R
import com.squareup.picasso.Picasso
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_details.*

    class Details : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_details)

            val tTitle = intent.getStringExtra("TaleTitle")
            val tContent = intent.getStringExtra("TaleContent")
            val tImage = intent.getStringExtra("TaleImage")

            supportActionBar?.title = tTitle
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            Picasso.get().load(tImage).into(tale_img_display)
            tale_display.text = tContent




        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if(item.itemId == android.R.id.home){
                onBackPressed()
            }
            return super.onOptionsItemSelected(item)
        }
    }
