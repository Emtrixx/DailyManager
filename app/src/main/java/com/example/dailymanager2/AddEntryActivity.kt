package com.example.dailymanager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import java.text.SimpleDateFormat

class AddEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val picker = findViewById<CalendarView>(R.id.datePicker)
        val smp = SimpleDateFormat("dd/MM/yyyy");
        var date = smp.format(System.currentTimeMillis())

        picker.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val month = if (month < 9) {
                "0${month + 1}"
            } else {
                "${month + 1}"
            }
            date = "${dayOfMonth}/${month}/${year}"
        }

        btnAdd.setOnClickListener {
            picker.date
            val entry = Entry(
                date,
                findViewById<EditText>(R.id.etTime).text.toString(),
                findViewById<EditText>(R.id.etName).text.toString(),
                findViewById<EditText>(R.id.etLocation).text.toString(),
                findViewById<EditText>(R.id.etNote).text.toString(),
            )
            Entries.addEntry(entry, this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}