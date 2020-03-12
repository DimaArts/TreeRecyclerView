package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.dimaarts.treerecyclerview.R
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeAdapter
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewDiffUtilCallback
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewHolder
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoTreeAdapter(items: ArrayList<RecyclerTreeViewItem>): RecyclerTreeAdapter<RecyclerTreeViewHolder>(items) {

    override fun getDiffUtilCallback(newItems: ArrayList<RecyclerTreeViewItem>): RecyclerTreeViewDiffUtilCallback {
        return DemoRecyclerTreeViewDiffUtilCallback(items, newItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerTreeViewHolder {
        if(viewType == 1) {
            val layoutInflater = LayoutInflater.from(parent.context)
            return DemoCatalogTreeViewHolder(layoutInflater.inflate(R.layout.item_catalog, parent, false))
        }
        else {
            val layoutInflater = LayoutInflater.from(parent.context)
            return DemoFileTreeViewHolder(layoutInflater.inflate(R.layout.item_file, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(flatVisibleItems[position] is DemoTreeTopLevelItem) return 1
        return 2
    }

    override fun areItemsTheSame(item1: RecyclerTreeViewItem?, item2: RecyclerTreeViewItem?): Boolean {
        return item1 is ItemWithId && item2 is ItemWithId && item1.id == item2.id
    }

}