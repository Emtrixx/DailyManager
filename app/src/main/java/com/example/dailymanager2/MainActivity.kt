package com.example.dailymanager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import android.widget.Toast
import com.example.dailymanager2.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Entries.readEntries(this)

        val smp = SimpleDateFormat("dd/MM/yyyy");
        var date = smp.format(System.currentTimeMillis())
        Log.i("DATEE", date)
        var entries = Entries.getEntries(date)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MainAdapter(entries)
        binding?.rvEntries?.adapter = adapter

        val picker = findViewById<CalendarView>(R.id.datePickerMain)
        picker.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val month = if (month < 9) {
                "0${month + 1}"
            } else {
                "${month + 1}"
            }
            date = "${dayOfMonth}/${month}/${year}"
            Log.i("DATEE", date)
            entries = Entries.getEntries(date)
            val adapter = MainAdapter(entries)
            binding?.rvEntries?.adapter = adapter
        }

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.btnGoToForm)
        floatingActionButton.setOnClickListener {
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