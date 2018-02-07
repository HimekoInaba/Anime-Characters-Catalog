package com.example.stusupbekov.animeCharactersCatalog.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.example.stusupbekov.animeCharactersCatalog.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loli.setOnClickListener({
            val i = Intent(this@MainActivity, CharacterActivity::class.java)
            startActivity(i)
        })

        blond.setOnClickListener({
            val i = Intent(this@MainActivity, CharacterActivity::class.java)
            startActivity(i)
        })
    }


}
