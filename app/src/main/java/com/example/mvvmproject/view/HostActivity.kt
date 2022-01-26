package com.example.mvvmproject.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmproject.R
import com.example.mvvmproject.view_model.HostActivityViewModel

class HostActivity : AppCompatActivity() {

    private val viewModel: HostActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        viewModel.liveData.observe(this, Observer {
            val characterDetailFragment = CharacterDetailFragment.newInstance(it)
            setFragment(characterDetailFragment)
        })
        val fragment = ListCharactersFragment()
        setFragment(fragment)
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}