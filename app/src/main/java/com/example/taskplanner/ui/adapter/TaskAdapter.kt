package com.example.taskplanner.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskplanner.R
import com.example.taskplanner.repository.remote.dto.TaskDto

class TaskAdapter(private val taskAdapterListener: TaskAdapterListener): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {


    private var taskList: List<TaskDto> = ArrayList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView = view.findViewById(R.id.textViewTaskDescription)
        val dueDate: TextView = view.findViewById(R.id.textViewTaskDueDate)
        val status: TextView = view.findViewById(R.id.textViewTaskStatus)
        val deleteTask: Button  = view.findViewById(R.id.buttonDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row,parent,false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        holder.description.text = task.description
        holder.dueDate.text = task.dueDate
        holder.status.text = task.status


        holder.deleteTask.setOnClickListener {
            taskAdapterListener.onDeleteTaskClicked(taskList, position)

        }


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