package com.example.qrgenerator

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Toast
import com.example.qrgenerator.databinding.ActivityMainBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeWidget()
    }

    private fun initializeWidget() {
        binding.qrGeneratorBtn.setOnClickListener {
            if (
                binding.nameEdtTxt.text.toString().isEmpty() ||
                binding.emailEdtTxt.text.toString().isEmpty() ||
                binding.ageEdtTxt.text.toString().isEmpty()
            ) {
                Toast.makeText(applicationContext, "Fill All Filed", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val text = "${binding.nameEdtTxt.text.toString()}\n${binding.emailEdtTxt.text.toString()}\n${binding.ageEdtTxt.text.toString()}\n"
                    val bitmap = BarcodeEncoder().encodeBitmap(text, BarcodeFormat.QR_CODE, 300, 300)
                    binding.imgQr.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}