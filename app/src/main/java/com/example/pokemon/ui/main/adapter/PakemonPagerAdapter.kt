package com.example.pokemon.ui.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.PokemonModel
import com.example.pokemon.databinding.ItemPagingBinding

class PakemonPagerAdapter(private val context: Context) :
    PagingDataAdapter<PokemonModel, PakemonPagerAdapter.MyViewHolder>(TaskDiffCallBack()) {

    class TaskDiffCallBack : DiffUtil.ItemCallback<PokemonModel>() {
        override fun areItemsTheSame(
            oldItem: PokemonModel,
            newItem: PokemonModel
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: PokemonModel,
            newItem: PokemonModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    private var itemLikeClickListener: ((replyId: String, like: Boolean, dislike: Boolean) -> Unit)? =
        null

    fun setItemLikeClickListener(f: (replyId: String, like: Boolean, dislike: Boolean) -> Unit) {
        itemLikeClickListener = f
    }

    private var itemClickListener: ((studentId: String) -> Unit)? = null

    fun setItemClickListener(f: (replyId: String) -> Unit) {
        itemClickListener = f
    }

    inner class MyViewHolder(var binding: ItemPagingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n", "CheckResult")
        fun bind(data: PokemonModel) {
            Log.d("RRRRR", "observe: $data")
            binding.nameTv.text = data.name
//            Database.getDatabase().addUser(data)
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${layoutPosition + 1}.png")
                .into(binding.image)

            itemView.setOnClickListener {
                itemClickListener?.invoke(data.name)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemPagingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        data?.let { holder.bind(it) }
    }
}