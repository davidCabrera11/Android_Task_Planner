package com.example.taskplanner.ui.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskAdapter(private val taskAdapterListener: TaskAdapterListener): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    private var taskList: List<TaskDto> = ArrayList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView = view.findViewById(R.id.textViewTaskDescription)
        var dueDate: TextView = view.findViewById(R.id.textViewTaskDueDate)
        val status: TextView = view.findViewById(R.id.textViewTaskStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]

        holder.description.text = task.description
        holder.dueDate.text = task.dueDate.subSequence(0,10)
        holder.status.text = task.status


        holder.itemView.setOnClickListener {
            taskAdapterListener.onTaskClicked(task)
        }


    }

    override fun getItemCount(): Int {
        return taskList.size

    }

    fun updateTaskList(task: List<TaskDto>){
        this.taskList = task
        notifyDataSetChanged()

    }


}