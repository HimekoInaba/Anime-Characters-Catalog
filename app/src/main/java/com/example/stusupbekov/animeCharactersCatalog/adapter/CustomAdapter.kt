package com.example.stusupbekov.animeCharactersCatalog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.stusupbekov.animeCharactersCatalog.R
import com.example.stusupbekov.animeCharactersCatalog.data.Character
import java.util.*


class CustomAdapter(var context: Context, var character: ArrayList<Character>) : BaseAdapter(){

    private class ViewHolder(row : View?){
        var txtName: TextView
        var ivImage: ImageView

        init {
            this.txtName = row?.findViewById<View>(R.id.txtName) as TextView
            this.ivImage = row?.findViewById<View>(R.id.ivCharacter) as ImageView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder

        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.pics, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var character: Character = getItem(position) as Character
        viewHolder.txtName.text = character.name
        viewHolder.ivImage.setImageResource(character.image)

        return view as View
    }

    override fun getItem(position: Int): Any {
        return character.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return character.count()
    }

}