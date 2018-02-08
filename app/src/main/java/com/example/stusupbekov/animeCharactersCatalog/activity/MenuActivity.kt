package com.example.stusupbekov.animeCharactersCatalog.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.stusupbekov.animeCharactersCatalog.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.menu.*

/**
 * Created by s.tusupbekov on 08.02.2018.
 */

class MenuActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        loli.setOnClickListener({
            val i = Intent(this@MenuActivity, CharacterActivity::class.java)
            startActivity(i)
        })

        blond.setOnClickListener({
            val i = Intent(this@MenuActivity, CharacterActivity::class.java)
            startActivity(i)
        })

        trap.setOnClickListener({
            val i = Intent(this@MenuActivity, CharacterActivity::class.java)
            startActivity(i)
        })

        monster.setOnClickListener({
            val i = Intent(this@MenuActivity, CharacterActivity::class.java)
            startActivity(i)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.logout){
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}