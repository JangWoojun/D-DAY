package com.example.d_day

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.startBtn)
        val end = findViewById<Button>(R.id.endBtn)

        var startDate = ""
        var endDate = ""

        start.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                    startDate =  year.toString() + (month+1).toString()+ day.toString()
                    Log.d("day : ",startDate)
                }

            },year,month,day)
            dlg.show()
        }

        end.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                    endDate =  year.toString() + (month+1).toString()+ day.toString()
                    Log.d("day : ",endDate)

                    findViewById<TextView>(R.id.showDate).setText((endDate.toInt() - startDate.toInt()+1).toString())
                }

            },year,month,day)
            dlg.show()
        }
        }

    }