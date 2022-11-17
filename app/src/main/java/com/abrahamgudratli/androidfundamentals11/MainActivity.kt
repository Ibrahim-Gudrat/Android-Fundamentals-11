package com.abrahamgudratli.androidfundamentals11

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("Registration", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = etvFirstName.text.toString()
            val surname = etvLastName.text.toString()
            val age = etvAge.text.toString().toInt()
            val degree = checkBox.isChecked

            editor.apply {
                putString("Name", name)
                putString("Surname", surname)
                putInt("Age", age)
                putBoolean("Degree", degree)
                apply()
            }

            Toast.makeText(this, "Details are saved", Toast.LENGTH_LONG).show()

        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("Name", null)
            val surname = sharedPref.getString("Surname", null)
            val age = sharedPref.getInt("Age", 0)
            val degree = sharedPref.getBoolean("Degree", false)

            etvFirstName.setText(name)
            etvLastName.setText(surname)
            etvAge.setText(age.toString())
            checkBox.isChecked = degree
        }



    }
}