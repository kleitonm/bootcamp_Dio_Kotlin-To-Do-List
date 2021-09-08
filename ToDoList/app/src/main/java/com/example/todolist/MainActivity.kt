package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter = ToDoAdapter(mutableListOf())

        rvToDoItems.adapter = ToDoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager( this)

        btnAddToDo.setOnClickListener {
            val ToDoTitle = etToDoTitle.text.toString()
            if(ToDoTitle.isNotEmpty()) {
                val ToDo = ToDo(ToDoTitle)
                ToDoAdapter.addToDo(ToDo)
                etToDoTitle.text.clear()
            }
        }
        btnFeleteDoneToDo.setOnClickListener {
            ToDoAdapter.deleteDoneToDo()
        }
    }
}