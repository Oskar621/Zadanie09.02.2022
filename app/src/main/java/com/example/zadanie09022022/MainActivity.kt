package com.example.zadanie09022022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.zadanie09022022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupAutoCompleteTextView()
    }

    private fun setupAutoCompleteTextView() {
        val countries = resources.getStringArray(R.array.countries_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        binding.autoCompleteTextView.setAdapter(adapter)

        binding.btnSubmit.setOnClickListener {
            val text = getString(R.string.entered_text) + " " + binding.autoCompleteTextView.text
            Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
        }
    }

}