package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class RecyclerTreeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var onClickListener: ((RecyclerTreeViewItem)->Unit)? = null

    open fun bind(item: RecyclerTreeViewItem) {
        itemView.setOnClickListener {
            notifyExpand(item)
        }
    }

    protected fun notifyExpand(item: RecyclerTreeViewItem) {
        onClickListener?.invoke(item)
    }

    open fun onExpand(item: RecyclerTreeViewItem, expanded: Boolean) {

    }
}