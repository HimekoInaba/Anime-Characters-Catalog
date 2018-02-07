package com.example.stusupbekov.animeCharactersCatalog.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.stusupbekov.animeCharactersCatalog.R
import com.example.stusupbekov.animeCharactersCatalog.adapter.CustomAdapter
import com.example.stusupbekov.animeCharactersCatalog.data.Character
import java.util.ArrayList


class CharacterActivity : AppCompatActivity() {

    var character: ArrayList<Character> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item)

        var listView = findViewById<ListView>(R.id.list_view) as ListView
        character.add(Character("Shinobu", R.drawable.shinobu))

        listView.adapter = CustomAdapter(applicationContext, character)
    }

}