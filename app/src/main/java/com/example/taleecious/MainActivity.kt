package com.example.taleecious

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_feed_back.*
//import itemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_story_list_names.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var taleTitle = arrayOf<String>()
    var taleContent = arrayOf<String>()
    var taleImage = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

         taleTitle = resources.getStringArray(R.array.taleTitles)
         taleContent = resources.getStringArray(R.array.taleContents)
         taleImage = resources.getStringArray(R.array.taleImages)

        val adapter = itemAdapter(taleTitle,taleContent,taleImage)
        taleList.layoutManager = LinearLayoutManager(this)
        taleList.adapter = adapter

    }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START) //whenever i click on menu items, they will bring on home

         if (item.itemId == R.id.home) {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
         }
         else if (item.itemId == R.id.random) {
            val randPosition = Random.nextInt(0,5)
            val intent = Intent(applicationContext,Details::class.java)
            intent.putExtra("storyTitle",taleTitle[randPosition])
            intent.putExtra("storyContent",taleContent[randPosition])
            intent.putExtra("storyImage",taleImage[randPosition])
            startActivity(intent)
        }
        else if (item.itemId == R.id.stories) {
            taleTitle = resources.getStringArray(R.array.taleTitles)
            val arrayAdapter : ArrayAdapter<String> = ArrayAdapter(this.applicationContext, android.R.layout.simple_list_item_1, taleTitle)
        }
        else if (item.itemId == R.id.contact) {
            val intent : Intent = Intent(this, contactUs::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.rate) {
            var intent : Intent = Intent(this, feedBack::class.java)
            startActivity(intent)


        }
        return true
     }
}



