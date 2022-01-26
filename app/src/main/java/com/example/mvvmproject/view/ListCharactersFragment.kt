package com.example.mvvmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvmproject.R
import com.example.mvvmproject.domain.DomainImpl
import com.example.mvvmproject.model.ResultsItem
import com.example.mvvmproject.view_model.HostActivityViewModel
import com.example.mvvmproject.view_model.ListCharactersFragmentViewModel
import com.example.mvvmproject.view_model.Repository
import com.example.mvvmproject.view_model.SampleViewModelFactory
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout

class ListCharactersFragment : Fragment() {

    private val spanCount = 3
    private val orientation = 1

    private lateinit var  swipeRefreshLayout: SwipyRefreshLayout

    private lateinit var characterRecyclerView: RecyclerView

    private val viewModelFromActivity: HostActivityViewModel by activityViewModels()

    private val viewModel: ListCharactersFragmentViewModel by lazy {
        ViewModelProviders.of(this, SampleViewModelFactory(repository))
            .get(ListCharactersFragmentViewModel::class.java)
    }
    private val adapter: SampleAdapter by lazy {
        SampleAdapter(mutableListOf(), ::getResultClicked)
    }
    private val repository by lazy {
        DomainImpl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_characters, container, false)
        characterRecyclerView = view.findViewById(R.id.character_recycler_view)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        configureSwipeRefresh()
        viewModel.getCharactersList()
        updateCharacterRecyclerView()
    }

    private fun configureSwipeRefresh() {
        swipeRefreshLayout.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        );

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.currentPage++
            viewModel.getCharactersList()
        }
    }

    private fun configureRecyclerView() {
        characterRecyclerView.adapter = adapter
    }

    private fun getResultClicked(result: ResultsItem){
        viewModelFromActivity.sendItem(result)
    }

    private fun updateCharacterRecyclerView() {
        viewModel.sampleViewModelLiveData.observe(requireActivity(), Observer { repository ->
            when (repository) {
                is Repository.Sucess -> {
                    adapter.updateCharactersToList(repository.response)
                    swipeRefreshLayout.isRefreshing = false
                }
                is Repository.Fail -> {
                    Toast.makeText(activity, repository.fail, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}