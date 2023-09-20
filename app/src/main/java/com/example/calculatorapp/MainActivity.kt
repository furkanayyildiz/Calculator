package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button9.setOnClickListener {
            binding.input.text = addTextToInput("9")
        }
        binding.button8.setOnClickListener {
            binding.input.text = addTextToInput("8")
        }
        binding.button7.setOnClickListener {
            binding.input.text = addTextToInput("7")
        }
        binding.button6.setOnClickListener {
            binding.input.text = addTextToInput("6")
        }
        binding.button5.setOnClickListener {
            binding.input.text = addTextToInput("5")
        }
        binding.button4.setOnClickListener {
            binding.input.text = addTextToInput("4")
        }
        binding.button3.setOnClickListener {
            binding.input.text = addTextToInput("3")
        }
        binding.button2.setOnClickListener {
            binding.input.text = addTextToInput("2")
        }
        binding.button1.setOnClickListener {
            binding.input.text = addTextToInput("1")
        }
        binding.button0.setOnClickListener {
            binding.input.text = addTextToInput("0")
        }
        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }
        binding.buttonSum.setOnClickListener {

            if (binding.input.text.isEmpty()) {
                Toast.makeText(this, "Please enter a number!", Toast.LENGTH_SHORT).show()
            } else if (binding.input.text.last() != '+') {
                binding.input.text = addTextToInput("+")
            }
        }
        binding.buttonResult.setOnClickListener {
            if (binding.input.text.isNotEmpty()) {
                val result = sumOperation(binding.input.text.toString())
                binding.output.text = result.toString()

            }else {
                Toast.makeText(this, "Please enter a number!", Toast.LENGTH_SHORT).show()
            }
        }

    }
     fun addTextToInput(value: String): String {
        return "${binding.input.text}$value"
    }
    private fun sumOperation(value: String): Int {

        var cleanedValue = value
        var result = 0

        if (value.endsWith("+")) {
            cleanedValue = value.removeSuffix("+")
            binding.input.text = cleanedValue
        }

        val numbers = cleanedValue.split("+")
        for (number in numbers) {
            result += number.toInt()
        }

        return result
    }
}