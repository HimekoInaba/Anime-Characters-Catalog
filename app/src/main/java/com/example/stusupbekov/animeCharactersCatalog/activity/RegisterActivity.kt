package com.example.stusupbekov.animeCharactersCatalog.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.stusupbekov.animeCharactersCatalog.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by s.tusupbekov on 07.02.2018.
 */
class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val regBtn = findViewById<Button>(R.id.register_btn) as Button

        mDatabase = FirebaseDatabase.getInstance().getReference("Usernames")

        regBtn.setOnClickListener({
            view -> register()
        })
    }

    private fun register(){
        val emailField = findViewById<EditText>(R.id.email_fld) as EditText
        val usernameField = findViewById<EditText>(R.id.username_fld) as EditText
        val passwordField = findViewById<EditText>(R.id.password_fld) as EditText
        val confirmPasswordField = findViewById<EditText>(R.id.confirm_fld) as EditText

        var email = emailField.text.toString()
        var username = usernameField.text.toString()
        var password = passwordField.text.toString()
        var confirmPassword = confirmPasswordField.text.toString()

        if(!username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful){
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Username").setValue(username)
                    Toast.makeText(this, "Successfully signed in", Toast.LENGTH_LONG).show()
                    startActivity(Intent( this, MainActivity::class.java))
                }else{
                Toast.makeText(this, "Error :C", Toast.LENGTH_LONG).show()
            }
            })
        }else{
            Toast.makeText(this, "Please enter the credentials!", Toast.LENGTH_LONG).show()
        }

    }

}