package com.example.mobileproject

import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberUtils.isGlobalPhoneNumber
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileproject.databinding.ActivityMain3Binding

class MainActivity2 : AppCompatActivity() {
    private var _binding : ActivityMain3Binding? = null
    private val binding get()=_binding!!

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
    fun validCellPhone(number: String?): Boolean {
        return Patterns.PHONE.matcher(number).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "MobileProject-Signup" ;

        binding.backbtn.setOnClickListener{
            val i = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(i)
        }
        binding.signupText.setOnClickListener{
            val i = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(i)
        }

        binding.createButton.setOnClickListener {
            if (!isValidEmail(binding.emailinput.editText!!.text.toString())) //validate email
                binding.emailinput.error="Wrong format"
            else
                binding.emailinput.error=""

            if (!validCellPhone(binding.phoneinput.editText!!.text.toString()))  //validate phone
                binding.phoneinput.error="Wrong format"
            else
                binding.phoneinput.error=""

            //check null
            if ( !TextUtils.isEmpty(binding.emailinput.editText!!.text.toString()) &&
                !TextUtils.isEmpty(binding.phoneinput.editText!!.text.toString()) &&
                !TextUtils.isEmpty(binding.nameinput.editText!!.text.toString()) &&
                !TextUtils.isEmpty(binding.passwordinput.editText!!.text.toString()) &&
                !TextUtils.isEmpty(binding.cpasswordinput.editText!!.text.toString()) ){

                if (isValidEmail(binding.emailinput.editText!!.text.toString()) && validCellPhone(binding.phoneinput.editText!!.text.toString()) ){

                    //check matching password and confirm password
                    if (binding.passwordinput.editText!!.text.toString() == binding.cpasswordinput.editText!!.text.toString()){
                        Toast.makeText(this@MainActivity2, "User created", Toast.LENGTH_LONG).show()
                        val i = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(i)
                    }
                    else
                        Toast.makeText(this@MainActivity2, "Password and confirm password doesn't match", Toast.LENGTH_LONG).show()
                }
            }
            else
                Toast.makeText(this@MainActivity2, "Please fill all the inputs", Toast.LENGTH_LONG).show()

        }
    }
}