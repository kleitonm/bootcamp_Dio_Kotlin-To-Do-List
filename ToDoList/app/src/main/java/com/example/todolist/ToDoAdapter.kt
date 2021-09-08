package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*
import java.nio.file.Files.size

class ToDoAdapter (
    private val toDo: MutableList<ToDo>
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override func onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.contex).inflate(
                R.layout.item_todo;
                parent,
                false
            )
        )
    }

    fun addToDo(ToDo: ToDo) {
        ToDo.add(ToDo)
        notifyItemInserted(ToDo.size - 1)
    }

    fun deleteDoneToDo() {
        ToDo.removeAll { ToDo ->
            ToDo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvToDoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else{
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        TODO("Not yet implemented")
        val curToDo = ToDo[position]
        holder.itemView.apply {
            tvToDoTitle.text = curToDo.title
            cbDone.isChecked = curToDo.isChecked
            toggleStrikeThrough(tvToDoTitle, curToDo.isChecked)
            cbDone.setOnCheckedChangeListener { , isChecked ->
            toggleStrikeThrough(tvToDoTitle, isChecek)
                curTodo.isChecked = !curToDo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return ToDo.size
    }
}