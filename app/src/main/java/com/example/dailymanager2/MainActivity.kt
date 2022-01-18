package com.example.dailymanager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.dailymanager2.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MainAdapter(Entries.entryList)
        binding?.rvEntries?.adapter = adapter

//        setContentView(R.layout.activity_main)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.btnGoToForm)
        floatingActionButton.setOnClickListener {
            Log.i("Meeee", "rentest")
            Toast.makeText(
                this@MainActivity, "Want to add a new entry",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(
                this@MainActivity,
                AddEntryActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}