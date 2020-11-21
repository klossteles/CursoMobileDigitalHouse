package com.klossteles.chucknorrisapi.joke.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.klossteles.chucknorrisapi.R
import com.klossteles.chucknorrisapi.category.view.CategoryListFragment
import com.klossteles.chucknorrisapi.joke.repository.JokeRepository
import com.klossteles.chucknorrisapi.joke.viewmodel.JokeViewModel
import com.squareup.picasso.Picasso

class JokeFragment : Fragment() {
    private lateinit var _view: View
    private lateinit var _viewModel: JokeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        _viewModel = ViewModelProvider(
            this,
            JokeViewModel.JokeViewModelFactory(JokeRepository())
        ).get(JokeViewModel::class.java)

        showLoading(true)
        val txtDescription = _view.findViewById<TextView>(R.id.txtDescription)
        val imgItem = _view.findViewById<ImageView>(R.id.imgItem)
        val category = arguments?.getString(CategoryListFragment.CATEGORY)
        _viewModel.getJoke(category).observe(viewLifecycleOwner, {
            showLoading(false)
            txtDescription.text = it.value
            Picasso.get()
                .load(it.iconUrl)
                .into(imgItem)
        })
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.jokeLoading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }
}