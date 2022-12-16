package com.example.taleecious

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_feed_back.*

class feedBack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_back)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val context =this
        btn_feedback.setOnClickListener({

            Toast.makeText(context, "Response Received", Toast.LENGTH_SHORT).show()
            if (editTextName.text.toString().length > 0 && editFeedback.text.toString().length > 0) {
                var user = userDatabase(editTextName.text.toString(), editFeedback.text.toString())
                var db = databaseHandler(context)
                db.insertData(user)
            }else {
                Toast.makeText(context, "Please fill your response", Toast.LENGTH_SHORT).show()
            }

        })



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}