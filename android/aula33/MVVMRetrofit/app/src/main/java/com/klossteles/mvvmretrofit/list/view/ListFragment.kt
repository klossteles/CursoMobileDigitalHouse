package com.klossteles.mvvmretrofit.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.mvvmretrofit.R
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import com.klossteles.mvvmretrofit.list.repository.CharacterRepository
import com.klossteles.mvvmretrofit.list.viewmodel.CharacterViewModel

class ListFragment : Fragment() {
    private lateinit var _viewModel: CharacterViewModel
    private lateinit var _view: View
    private lateinit var _listAdapter: ListAdapter

    var _charactersList = mutableListOf<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        val list = view.findViewById<RecyclerView>(R.id.list)
        val manager = LinearLayoutManager(view.context)

        _charactersList = mutableListOf<CharacterModel>()
        _listAdapter = ListAdapter(_charactersList)

        list.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = _listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CharacterViewModel.CharacterViewModelFactory(CharacterRepository())
        ).get(CharacterViewModel::class.java)

        _viewModel.getList().observe(viewLifecycleOwner, Observer {
            showResults(it)
        })

        initSearch()
        showLoading(true)
    }

    private fun showResults(list: List<CharacterModel>?) {
        showLoading(false)
        list?.isNotEmpty()?.let { notFound(it) }
        _charactersList.clear()
        list?.let { _charactersList.addAll(it) }
        _listAdapter.notifyDataSetChanged()
    }

    private fun initSearch() {
        val searchView = _view.findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                _viewModel.search(query).observe(viewLifecycleOwner, {
                    showResults(it)
                })
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isBlank()) {
                    showResults(_viewModel.returnFirstList())
                }
                return true
            }
        })
        _viewModel.getList()
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.loading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    private fun notFound(notFound: Boolean) {
        if (notFound) {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.VISIBLE
        }
    }
}