package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

import androidx.recyclerview.widget.DiffUtil
import ru.dimaarts.treerecyclerviewlibrary.utils.Utils

abstract class RecyclerTreeViewDiffUtilCallback(private val oldList: ArrayList<RecyclerTreeViewItem>, private val newList: ArrayList<RecyclerTreeViewItem>): DiffUtil.Callback() {
    val oldVisibleList: List<RecyclerTreeViewItem> = Utils.getFlatVisibleItems(oldList)
    val newVisibleList: List<RecyclerTreeViewItem> = Utils.getFlatVisibleItems(newList)

    override fun getOldListSize(): Int {
        return oldVisibleList.size
    }

    override fun getNewListSize(): Int {
        return newVisibleList.size
    }

}