package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        readData()
    }
    private fun init(){
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE)
    }

    fun save(view: View){
        val email = Email.text.toString()
        val firstname = Firstname.text.toString()
        val lastname = Lastname.text.toString()
        val age = Age.text.toString()
        val address = Address.text.toString()
        val edit = sharedPreferences.edit()


        if(email.isNotEmpty() && firstname.isNotEmpty() && lastname.isNotEmpty() && address.isNotEmpty() && age.isNotEmpty()){
            edit.putString("firstname", firstname)
            edit.putString("lastname", lastname)
            edit.putString("email", email)
            edit.putString("Age", age)
            edit.putString("address", address)
            edit.apply()
            Toast.makeText(this, "Information saved", Toast.LENGTH_SHORT).show()
        }else
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_SHORT).show()
    }

    private fun readData(){
        val email = sharedPreferences.getString("email", "")
        val firstname = sharedPreferences.getString("firstname", "")
        val lastname = sharedPreferences.getString("lastname", "")
        val age = sharedPreferences.getString("Age", "0")
        val address = sharedPreferences.getString("address", "")

        Email.setText(email)
        Firstname.setText(firstname)
        Lastname.setText(lastname)
        Age.setText(age.toString())
        Address.setText(address)


    }
}