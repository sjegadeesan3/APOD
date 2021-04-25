package com.jegadeesan.apod.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jegadeesan.apod.R
import com.jegadeesan.apod.databinding.ApodLiteItemBinding
import com.jegadeesan.apod.domain.data.Apod

class ApodRecyclerView(val apodList: List<Apod>) : RecyclerView.Adapter<ApodRecyclerView.ApodViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApodViewHolder {
        val binding = ApodLiteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        holder.setUi(apodList[position])
    }

    override fun getItemCount(): Int {
        return apodList.size
    }

    class ApodViewHolder(private val binding: ApodLiteItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun setUi(apod: Apod) {
            binding.date.text = apod.date
            binding.title.text = apod.title
            if (apod.thumbnailUrl.isNullOrEmpty()) {
                Glide
                    .with(binding.root.context)
                    .load(apod.url)
                    .placeholder(R.drawable.default_image)
                    .dontAnimate()
                    .into(binding.imageView)
            } else {
                Glide
                    .with(binding.root.context)
                    .load(apod.thumbnailUrl)
                    .placeholder(R.drawable.default_image)
                    .dontAnimate()
                    .into(binding.imageView)

            }

        }

    }
}