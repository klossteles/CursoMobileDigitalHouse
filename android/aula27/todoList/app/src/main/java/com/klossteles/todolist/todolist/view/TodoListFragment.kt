package com.klossteles.todolist.todolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.klossteles.todolist.R

class TodoListFragment : Fragment() {
    private lateinit var minhaView: View

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_todo_list, container, false)
        // Inflate the layout for this fragment
        return minhaView
    }
}