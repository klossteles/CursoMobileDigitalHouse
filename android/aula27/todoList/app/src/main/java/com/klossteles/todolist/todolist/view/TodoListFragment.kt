package com.klossteles.todolist.todolist.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.klossteles.todolist.R
import com.klossteles.todolist.task.model.TaskModel
import com.klossteles.todolist.task.repository.TaskRepository
import com.klossteles.todolist.todolist.viewmodel.TodoListViewModel

class TodoListFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel: TodoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,
            TodoListViewModel.ListTodoListViewModelFactory(TaskRepository())
        ).get(TodoListViewModel::class.java)

        viewModel.tasks.observe(this, Observer {
            createList(it)
        })

        viewModel.getList()
    }

    fun createList(tasks: List<TaskModel>) {
        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.list)
        val manager = LinearLayoutManager(context)

        val customAdapter = TodoListAdapter(tasks) {
//            val intent = Intent(this, DetalhesActivity::class.java)
//            intent.putExtra("IMAGEM", it.imagemUrl)
//            intent.putExtra("NOME", it.nome)
//            intent.putExtra("GENERO", it.genero)
//            intent.putExtra("PLANETA", it.localizacao.nome)
//
//            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = customAdapter
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_todo_list, container, false)
        minhaView.findViewById<MaterialButton>(R.id.btnAddNewTask).setOnClickListener {
            Toast.makeText(context,  "Adicionar Task", Toast.LENGTH_LONG).show()
        }
        // Inflate the layout for this fragment
        return minhaView
    }
}