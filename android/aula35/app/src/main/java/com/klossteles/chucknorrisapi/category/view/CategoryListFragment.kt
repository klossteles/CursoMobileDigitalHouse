package com.klossteles.chucknorrisapi.category.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.chucknorrisapi.R
import com.klossteles.chucknorrisapi.category.repository.CategoryRepository
import com.klossteles.chucknorrisapi.category.viewmodel.CategoryViewModel
import java.util.*

class CategoryListFragment : Fragment() {
    private lateinit var _viewModel: CategoryViewModel
    private lateinit var _view: View
    private lateinit var _listAdapter: CategoryListAdapter

    private var _categories = mutableListOf<String>()
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

        val list = _view.findViewById<RecyclerView>(R.id.list)
        val manager = LinearLayoutManager(_view.context)

        _categories = mutableListOf<String>()
        _listAdapter = CategoryListAdapter(_categories) {
            val bundle = bundleOf(CATEGORY to it.decapitalize(Locale.ROOT))
            _view.findNavController().navigate(R.id.action_categoryListFragment_to_jokeFragment, bundle)
        }

        list.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CategoryViewModel.CategoryViewModelFactory(CategoryRepository())
        ).get(CategoryViewModel::class.java)

        showLoading(true)
        _viewModel.getCategoriesList().observe(viewLifecycleOwner, {
            showLoading(false)
            _categories.addAll(it)
            _listAdapter.notifyDataSetChanged()
        })
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.categoryLoading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    companion object {
        const val CATEGORY = "CATEGORY"
    }
}