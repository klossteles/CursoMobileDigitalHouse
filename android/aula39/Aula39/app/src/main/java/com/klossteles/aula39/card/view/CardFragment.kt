package com.klossteles.aula39.card.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.aula39.R
import com.klossteles.aula39.card.entity.CardEntity
import com.klossteles.aula39.card.repository.CardRepository
import com.klossteles.aula39.card.viewmodel.CardViewModel
import com.klossteles.aula39.dp.AppDatabase

class CardFragment : Fragment() {
    private lateinit var _viewModel: CardViewModel
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view
        _viewModel = ViewModelProvider(
            this,
            CardViewModel.CardViewModelFactory(CardRepository(AppDatabase.getDatabase(view.context).cardDao()))
        ).get(CardViewModel::class.java)

        registerCard(CardEntity(0, "0000111122223333", "Test", "123", "10/10", "Master"))
        registerCard(CardEntity(0, "1000111122223333", "Test", "123", "10/10", "Master"))
        registerCard(CardEntity(0, "2000111122223333", "Test", "123", "10/10", "Master"))
        registerCard(CardEntity(0, "3000111122223333", "Test", "123", "10/10", "Master"))

        _viewModel.getCount().observe(viewLifecycleOwner, {
            _view.findViewById<TextView>(R.id.txtQuantity).text = it.toString()
        })
    }

    private fun registerCard(cardEntity: CardEntity) {
        _viewModel.addCard(cardEntity)
    }
}