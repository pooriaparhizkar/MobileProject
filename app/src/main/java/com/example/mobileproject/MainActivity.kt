package com.example.mobileproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileproject.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private var _binding :ActivityMainBinding? = null
    private val binding get()=_binding!!

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "MobileProject-Login" ;

        //change facebook btn color after clicking
       binding.facebook.setOnClickListener {
           val color = Random()
           binding.facebook.setBackgroundColor(
               Color.argb(
                   255,
                   color.nextInt(255),
                   color.nextInt(255),
                   color.nextInt(255)
               )
           )

       }
        //change google btn color after clicking
        binding.google.setOnClickListener {
            val color = Random()
            binding.google.setBackgroundColor(
                Color.argb(
                    255,
                    color.nextInt(255),
                    color.nextInt(255),
                    color.nextInt(255)
                )
            )
            Log.d("TAG",binding.emailInput.editText!!.text.toString())
        }
        //Login btn click function
        binding.nextButton.setOnClickListener {
            if (!isValidEmail(binding.emailInput.editText!!.text.toString())) //validate email
                binding.emailInput.error="Wrong format"
            else {
                binding.emailInput.error=""
                Toast.makeText(this@MainActivity, "Login successful", Toast.LENGTH_SHORT).show()
            }
        }

        //redirect to signup page
        binding.signupText.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}