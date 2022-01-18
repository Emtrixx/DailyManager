package com.example.dailymanager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText

class AddEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val picker = findViewById<CalendarView>(R.id.datePicker)
        var date = "22/05/2021"

        picker.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
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
            Entries.entryList.add(entry)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}