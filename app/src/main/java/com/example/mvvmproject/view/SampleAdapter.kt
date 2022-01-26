package com.example.mvvmproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmproject.R
import com.example.mvvmproject.model.ResultsItem
import com.squareup.picasso.Picasso

class SampleAdapter(
    var characterList: MutableList<ResultsItem>,
    private val clickListener: (ResultsItem) -> Unit
) :
    RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.character_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characterList[position], clickListener)
    }

    fun updateCharactersToList(characterList: List<ResultsItem>) {
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = characterList.size

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        private val nameTextView: TextView = view.findViewById(R.id.character_name)
        private val imageTextView: ImageView = view.findViewById(R.id.char_image)

        fun onBind(character: ResultsItem, clickListener: (result: ResultsItem) -> Unit) {
            nameTextView.text = character.name
            Picasso.get().load(character.image).into(imageTextView)
            view.setOnClickListener {
                clickListener(character)
            }
        }
    }
}