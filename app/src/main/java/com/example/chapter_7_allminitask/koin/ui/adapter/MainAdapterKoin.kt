package com.example.chapter_7_allminitask.koin.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_7_allminitask.databinding.ItemContentBinding
import com.example.chapter_7_allminitask.koin.data.model.GetAllPostsResponseItemKoin

class MainAdapterKoin : RecyclerView.Adapter<MainAdapterKoin.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<GetAllPostsResponseItemKoin>() {
        override fun areItemsTheSame(
            oldItem: GetAllPostsResponseItemKoin,
            newItem: GetAllPostsResponseItemKoin
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: GetAllPostsResponseItemKoin,
            newItem: GetAllPostsResponseItemKoin
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<GetAllPostsResponseItemKoin>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemContentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GetAllPostsResponseItemKoin) {
            binding.apply {
                tvTitle.text = data.title
            }
        }
    }
}