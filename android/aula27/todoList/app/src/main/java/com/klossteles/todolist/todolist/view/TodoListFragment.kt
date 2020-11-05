package com.klossteles.todolist.todolist.view

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.marginStart
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
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

        val customAdapter = TodoListAdapter(tasks, viewModel) {

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
        addNewTask()
        // Inflate the layout for this fragment
        return minhaView
    }

    private fun addNewTask() {
        val toast: Toast? = null
        minhaView.findViewById<MaterialButton>(R.id.btnAddNewTask).setOnClickListener {
            context?.let { it1 ->
                toast?.cancel()
                val newTaskView = layoutInflater.inflate(R.layout.new_task, null)
                addDialog(it1, newTaskView)
                checkNewTaskDesc(newTaskView)
            }
        }
    }

    private fun checkNewTaskDesc(newTaskView: View) {
        newTaskView.findViewById<TextInputEditText>(R.id.edtDescNewTask)
            .addTextChangedListener(object :
                TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    newTaskView.findViewById<TextInputLayout>(R.id.txtDescNewTask).error = ""
                }
            })
    }

    private fun addDialog(it1: Context, newTaskView: View) {
        val dialog = MaterialAlertDialogBuilder(it1)
            .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                Toast.makeText(context, "Cancel new Task", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton(getString(R.string.create), null)
            .setView(newTaskView)
            .show()

        val positiveBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveBtn.setOnClickListener {
            val edtNewTask = newTaskView.findViewById<TextInputLayout>(R.id.txtDescNewTask)
            val desc = edtNewTask.editText?.text.toString()

            if (desc.isEmpty()) {
                edtNewTask.error = "Insert task description"
                return@setOnClickListener
            }

            val response = viewModel.addNewTask(TaskModel(desc))
            if (response.isEmpty()) {
                Toast.makeText(context, "Task added to Todo List", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            } else {
                Toast.makeText(context, response, Toast.LENGTH_LONG).show()
            }
        }
    }
}