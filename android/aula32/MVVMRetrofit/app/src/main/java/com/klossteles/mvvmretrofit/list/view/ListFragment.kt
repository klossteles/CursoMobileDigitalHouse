package com.klossteles.mvvmretrofit.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val lista = view.findViewById<RecyclerView>(R.id.list)
        val manager = LinearLayoutManager(view.context)

        val charactersList = mutableListOf<CharacterModel>()
        val listAdapter = ListAdapter(charactersList)

        lista.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CharacterViewModel.CharacterViewModelFactory(CharacterRepository())
        ).get(CharacterViewModel::class.java)

        _viewModel.characters.observe(this, Observer {
            showLoading(false)
            notFound(it.isNotEmpty())

            charactersList.addAll(it)
            listAdapter.notifyDataSetChanged()
        })

        _viewModel.getList()
        showLoading(true)
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