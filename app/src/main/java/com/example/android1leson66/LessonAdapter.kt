package com.example.android1leson66

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android1leson66.databinding.ItemLessonBinding

class LessonAdapter(val data: ArrayList<LessonModel>) :
    RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(ItemLessonBinding.inflate(LayoutInflater.from(
            parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


  inner  class LessonViewHolder(private val binding: ItemLessonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lessonModel: LessonModel) {
            data
            binding.txtLesson.text = lessonModel.text
            Glide.with(binding.image).load(lessonModel.image).into(binding.image)
        }

    }
}