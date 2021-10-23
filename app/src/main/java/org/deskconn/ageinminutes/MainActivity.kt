package org.deskconn.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerBtn = findViewById<Button>(R.id.btnDatePicker)

        datePickerBtn.setOnClickListener {view ->
            clickDatePicker(view)
             }
    }
    fun clickDatePicker(view: View){

        val tvSelectedDate = findViewById<TextView>(R.id.tvSelectDate)
        val myCalendar = Calendar.getInstance() //This calendar class allow us to create the calendar objects
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->    //This statement will be executed once the datePicker dialogue displayed
                Toast.makeText(this, "The Chosen year is $year, the month is $month, and the day is $selectedDayOfMonth",Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy")
                val theDate = sdf.parse(selectedDate)
            }
            ,year
            ,month
            ,day).show()
    }
}

