package com.dinesharyal.softuserclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dinesharyal.softuserclone.R
import com.dinesharyal.softuserclone.model.student

class StudentAdapter(
        val lstStudents:ArrayList<student>,
        val context:Context
):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view:View)
        :RecyclerView.ViewHolder(view){
            val tvName:TextView
            val tvAge:TextView
            val tvAddress:TextView
            val tvGender:TextView
            val imgProfile:ImageView
            val deleteIcon:ImageView

            init {
                tvName=view.findViewById(R.id.tvName)
                tvAge=view.findViewById(R.id.tvAge)
                tvAddress=view.findViewById(R.id.tvAddress)
                tvGender=view.findViewById(R.id.tvGender)
                imgProfile=view.findViewById(R.id.imgView)
                deleteIcon=view.findViewById(R.id.imageView)

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.my_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student=lstStudents[position]
        holder.tvName.text=student.studentName
        holder.tvAge.text=student.studentAge.toString()
        holder.tvAddress.text=student.studentAddress
        holder.tvGender.text=student.studentGender
        Glide.with(context).load(student.imageLink)
                .into(holder.imgProfile)

        holder.deleteIcon.setOnClickListener {
            lstStudents.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }

//    fun remove(position:Int){
//        lstStudents.removeAt(position)
//        notifyItemRemoved(position)
//        notifyItemChanged(position,lstStudents.size)
//    }
}