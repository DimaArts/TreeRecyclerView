package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

import androidx.recyclerview.widget.DiffUtil
import ru.dimaarts.treerecyclerviewlibrary.utils.Utils

abstract class RecyclerTreeViewDiffUtilCallback(
    oldList: ArrayList<RecyclerTreeViewItem>,
    newList: ArrayList<RecyclerTreeViewItem>
) : DiffUtil.Callback() {
    protected val oldVisibleList: List<RecyclerTreeViewItem> = Utils.getFlatVisibleItems(oldList)
    protected val newVisibleList: List<RecyclerTreeViewItem> = Utils.getFlatVisibleItems(newList)

    override fun getOldListSize(): Int {
        return oldVisibleList.size
    }

    override fun getNewListSize(): Int {
        return newVisibleList.size
    }

}