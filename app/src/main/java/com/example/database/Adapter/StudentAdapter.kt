package com.example.database.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.database.R
import com.example.database.StudentModel

class StudentAdapter(list: ArrayList<StudentModel>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    var list = list
    class StudentHolder(itemView: View) : ViewHolder(itemView){
        var id = itemView.findViewById<TextView>(R.id.Id)
        var name = itemView.findViewById<TextView>(R.id.name)
        var surname = itemView.findViewById<TextView>(R.id.surname)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent)
        return StudentHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {

        holder.id.text = list.get(position).id.toString()
        holder.name.text = list.get(position).name
        holder.surname.text = list.get(position).surname
}

    fun update(students : java.util.ArrayList<StudentModel>){
        list = students
        notifyDataSetChanged()
    }
}