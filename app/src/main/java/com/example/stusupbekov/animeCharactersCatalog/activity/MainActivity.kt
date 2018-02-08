package com.example.stusupbekov.animeCharactersCatalog.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.stusupbekov.animeCharactersCatalog.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth


    class MainActivity : AppCompatActivity() {

        val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<View>(R.id.login_button) as Button
        val registerBtn = findViewById<View>(R.id.register_button) as Button

        loginBtn.setOnClickListener({
            view -> login()
        })

        registerBtn.setOnClickListener({
            view -> register()
        })

    }

    private fun login(){
        val emailField = findViewById<View>(R.id.email_fld) as EditText
        val passwordField = findViewById<View>(R.id.username_fld) as EditText

        var email = emailField.text.toString()
        var password = passwordField.text.toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MenuActivity::class.java))
                } else {
                    Toast.makeText(this, "Error :C", Toast.LENGTH_LONG).show()
                }
            })
        }else{
            Toast.makeText(this, "Please fill email and password fields! C:", Toast.LENGTH_LONG).show()
        }
    }

    private fun register(){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}
