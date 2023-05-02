package com.vedantjha.mvvmdaggerdemo2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vedantjha.mvvmdaggerdemo2.data.model.ImageResponse
import com.vedantjha.mvvmdaggerdemo2.databinding.ImageItemBinding

class ImagePagingAdapter(private val navigate: (ImageResponse, ImageView) -> Unit) :
    PagingDataAdapter<ImageResponse, ImagePagingAdapter.ImageListItemViewHolder>(DiffCallback()) {


    override fun onBindViewHolder(holder: ImageListItemViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListItemViewHolder {
        return ImageListItemViewHolder(
            binding = ImageItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    inner class ImageListItemViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var response: ImageResponse? = null

        fun bind(imageResponse: ImageResponse, position: Int) {
            this.response = response
            binding.apply {
                image = response
                shouldRound = true

                binding.root.setOnClickListener {
                    //navigate.invoke(imageResponse, binding.imageView)
                    Toast.makeText(binding.root.context, "clicked: $position ${getItem(position)?.urls?.regular}", Toast.LENGTH_SHORT).show()

                }
                Glide.with(binding.root.context).load(getItem(position)?.urls?.regular).into(binding.imageView)
                executePendingBindings()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ImageResponse>() {
        override fun areItemsTheSame(oldItem: ImageResponse, newItem: ImageResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageResponse, newItem: ImageResponse): Boolean {
            return oldItem == newItem
        }

    }

}