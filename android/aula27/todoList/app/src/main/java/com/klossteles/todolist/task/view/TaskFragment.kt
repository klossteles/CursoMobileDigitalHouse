package com.klossteles.todolist.task.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.klossteles.todolist.R

class TaskFragment : Fragment() {
    lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_task, container, false)
        // Inflate the layout for this fragment
        return minhaView
    }
}