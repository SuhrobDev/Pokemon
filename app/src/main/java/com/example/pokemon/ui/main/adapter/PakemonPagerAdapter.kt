package com.example.pokemon.ui.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.PokemonModel
import com.example.pokemon.databinding.ItemGrid1Binding
import com.example.pokemon.databinding.ItemGridBinding
import com.example.pokemon.databinding.ItemPagingBinding

class PakemonPagerAdapter(private val context: Context) :
    PagingDataAdapter<PokemonModel, RecyclerView.ViewHolder>(TaskDiffCallBack()) {
    var manager = 0

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

//    inner class MyViewHolder(var binding: ItemPagingBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        @SuppressLint("SetTextI18n", "CheckResult")
//        fun bind(data: PokemonModel) {
//            Log.d("RRRRR", "observe: $data")
//            binding.nameTv.text = data.name
////            Database.getDatabase().addUser(data)
//            Glide.with(context)
//                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${layoutPosition + 1}.png")
//                .into(binding.image)
//
//            itemView.setOnClickListener {
//                itemClickListener?.invoke(data.name)
//            }
//        }
//    }

    inner class LinearViewHolder(private val binding: ItemPagingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonModel) {
            binding.nameTv.text = data.name

            itemView.setOnClickListener {
                itemClickListener?.invoke(data.name)
            }

            val url = data.url.substring(34)
            val end = url.reversed().substring(1)

            Log.d("sdfkndfkfndjgntungtugn", "bind: $end")
//            binding.image.loadImage(context, end)
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${layoutPosition + 1}.png")
                .into(binding.image)
        }
    }

    inner class GridViewHolder(private val binding: ItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonModel) {
            binding.name.text = data.name
            itemView.setOnClickListener {
                itemClickListener?.invoke(data.name)
            }

            val url = data.url.substring(34)
            val end = url.reversed().substring(1)

            Log.d("sdfkndfkfndjgntungtugn", "bind: $end")
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${layoutPosition + 1}.png")
                .into(binding.image)
//            binding.image.loadImage(context, end)
        }
    }

    inner class Grid1ViewHolder(private val binding: ItemGrid1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonModel) {
            binding.name.text = data.name

            itemView.setOnClickListener {
                itemClickListener?.invoke(data.name)
            }

            val url = data.url.substring(34)
            val end = url.reversed().substring(1)

            Log.d("sdfkndfkfndjgntungtugn", "bind: $end")
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${layoutPosition + 1}.png")
                .into(binding.image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (manager) {
            0 -> {
                1
            }
            1 -> {
                2
            }
            2 -> {
                3
            }
            else -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                return LinearViewHolder(
                    ItemPagingBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            2 -> {
                return GridViewHolder(
                    ItemGridBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            3 -> {
                return Grid1ViewHolder(
                    ItemGrid1Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                return LinearViewHolder(
                    ItemPagingBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        if (getItemViewType(position) == 1) {
            val receive = holder as LinearViewHolder
            data?.let { receive.bind(it) }
        } else if (getItemViewType(position) == 2) {
            val receive = holder as GridViewHolder
            data?.let { receive.bind(it) }
        } else if (getItemViewType(position) == 3) {
            val receive = holder as Grid1ViewHolder
            data?.let { receive.bind(it) }
        }
    }
}