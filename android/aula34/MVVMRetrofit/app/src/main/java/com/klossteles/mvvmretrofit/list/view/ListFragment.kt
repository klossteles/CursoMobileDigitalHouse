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
    private lateinit var _recyclerView: RecyclerView
    private lateinit var _searchView: SearchView

    private var _charactersList = mutableListOf<CharacterModel>()
    private var _name: String? = null

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
        _recyclerView = _view.findViewById<RecyclerView>(R.id.list)

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

        showLoading(true)
        initSearch()
        setScrollView()
    }

    private fun showResults(list: List<CharacterModel>?) {
        showLoading(false)
        list?.isNotEmpty()?.let { notFound(it) }
        list?.let { _charactersList.addAll(it) }
        _listAdapter.notifyDataSetChanged()
    }

    private fun initSearch() {
        _searchView = _view.findViewById<SearchView>(R.id.searchView)
        _searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                _searchView.clearFocus()
                _name = query
                if (query.isEmpty()) {
                    _viewModel.getList().observe(viewLifecycleOwner, {
                        _charactersList.clear()
                        showResults(it)
                    })
                } else {
                    _viewModel.search(query).observe(viewLifecycleOwner, {
                        _charactersList.clear()
                        showResults(it)
                    })
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isBlank()) {
                    _name = null
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

    private fun setScrollView() {
        _recyclerView.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val target = recyclerView.layoutManager as LinearLayoutManager?
                    val totalItemCount = target!!.itemCount
                    val lastVisible = target.findLastVisibleItemPosition()
                    val lastItem = lastVisible + 5 >= totalItemCount
                    if (totalItemCount > 0 && lastItem) {
                        _viewModel.nextPage(_name).observe(viewLifecycleOwner, Observer {
                            showResults(it)
                        })
                    }
                }
            })
        }
    }
}