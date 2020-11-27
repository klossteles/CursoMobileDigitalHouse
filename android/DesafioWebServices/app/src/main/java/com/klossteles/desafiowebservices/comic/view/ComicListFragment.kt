package com.klossteles.desafiowebservices.comic.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafiowebservices.R
import com.klossteles.desafiowebservices.comic.model.ComicsModel
import com.klossteles.desafiowebservices.comic.repository.ComicRepository
import com.klossteles.desafiowebservices.comic.viewmodel.ComicViewModel

class ComicListFragment : Fragment() {
    private lateinit var _viewModel: ComicViewModel
    private lateinit var _view:View
    private lateinit var _listAdapter: ComicListAdapter
    private lateinit var _recyclerView: RecyclerView

    private var _comics = mutableListOf<ComicsModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        val list = _view.findViewById<RecyclerView>(R.id.rvComicList)
        val manager = GridLayoutManager(_view.context, 3)
        _comics = mutableListOf<ComicsModel>()
        _listAdapter = ComicListAdapter(_comics) {
//            val bundle = bundleOf(SERIES_ID to it.id)
//            _view.findNavController().navigate(R.id.action_seriesListFragment_to_seriesFragment, bundle)
        }

        _recyclerView = _view.findViewById<RecyclerView>(R.id.rvComicList)
        list.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.getList().observe(viewLifecycleOwner, Observer {
            _comics.addAll(it)
            _listAdapter.notifyDataSetChanged()
            showLoading(false)
        })
        showLoading(true)
        setScrollView()
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.comicsLoading)
        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    private fun setScrollView() {
        _recyclerView.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val target = recyclerView.layoutManager as GridLayoutManager?
                    val totalItemCount = target!!.itemCount
                    val lastVisible = target.findLastVisibleItemPosition()
                    val lastItem = lastVisible + 6 >= totalItemCount
                    if (totalItemCount > 0 && lastItem) {
                        showLoading(true)
                        _viewModel.nextPage().observe(viewLifecycleOwner, Observer {
                            _comics.addAll(it)
                            _listAdapter.notifyDataSetChanged()
                            showLoading(false)
                        })
                    }
                }
            })
        }
    }

    companion object {
        const val COMICS_ID = "COMICS_ID"
    }
}