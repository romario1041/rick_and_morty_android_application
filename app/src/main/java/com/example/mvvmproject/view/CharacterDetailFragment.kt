package com.example.mvvmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mvvmproject.R
import com.example.mvvmproject.model.ResultsItem
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"

class CharacterDetailFragment : Fragment() {

    private var resultsItem: ResultsItem? = null

    lateinit var textCharacterAbout: TextView
    lateinit var characterPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            resultsItem = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)
        textCharacterAbout = view.findViewById(R.id.char_text_about)
        characterPhoto = view.findViewById(R.id.char_photo)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultsItem?.apply {
            Picasso.get().load(this.image).resize(2000,1000).into(characterPhoto)
            textCharacterAbout.text = this.name
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(resultsItem: ResultsItem) =
            CharacterDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, resultsItem)
                }
            }
    }
}