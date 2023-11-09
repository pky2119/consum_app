package com.example.consum_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import java.util.Locale
import java.text.SimpleDateFormat

class Calendar : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)

        val productName = intent.getStringExtra("productName")
        val purchaseDate = intent.getStringExtra("purchaseDate")
        val expirationDate = intent.getStringExtra("expirationDate")

        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val purchaseDateAsDate = sdf.parse(purchaseDate)
        val expirationDateAsDate = sdf.parse(expirationDate)

        calendarView.date = purchaseDateAsDate?.time ?: 0

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = String.format("%d-%02d-%02d", year, month + 1, dayOfMonth)
            if (selectedDate == purchaseDate) {
                Toast.makeText(this, "$productName 구매일", Toast.LENGTH_SHORT).show()
            } else if (selectedDate == expirationDate) {
                Toast.makeText(this, "$productName 소비기한", Toast.LENGTH_SHORT).show()
            }
        }
    }
}