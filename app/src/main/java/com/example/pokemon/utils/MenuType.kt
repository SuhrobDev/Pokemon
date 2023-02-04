package com.example.pokemon.utils

import android.content.Context
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupMenu
import com.example.pokemon.R

class MenuType(context: Context, imageView: ImageView) : PopupMenu(context, imageView) {

    private var grid1ClickListener: (() -> Unit)? = null

    fun setGrid1ClickListener(f: () -> Unit) {
        grid1ClickListener = f
    }

    private var gridClickListener: (() -> Unit)? = null

    fun setGridClickListener(f: () -> Unit) {
        gridClickListener = f
    }

    private var linearClickListener: (() -> Unit)? = null

    fun setLinearClickListener(f: () -> Unit) {
        linearClickListener = f
    }

    init {
        menuInflater.inflate(R.menu.menu, menu)
        setOnMenuItemClickListener(object : MenuItem.OnMenuItemClickListener,
            OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.linear -> {
                        linearClickListener?.invoke()
                    }
                    R.id.grid -> {
                        gridClickListener?.invoke()
                    }
                    R.id.grid_1 -> {
                        grid1ClickListener?.invoke()
                    }
                    else -> {
                        return false
                    }
                }
                return true
            }
        })
    }
}