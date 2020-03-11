package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewDiffUtilCallback
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoRecyclerTreeViewDiffUtilCallback(oldList: ArrayList<RecyclerTreeViewItem>, newList: ArrayList<RecyclerTreeViewItem>): RecyclerTreeViewDiffUtilCallback(oldList, newList) {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldVisibleList[oldItemPosition]
        val newItem = newVisibleList[newItemPosition]
        return oldItem is DemoTreeCategoryItem && newItem is DemoTreeCategoryItem && oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldVisibleList[oldItemPosition]
        val newItem = newVisibleList[newItemPosition]
        return oldItem is DemoTreeCategoryItem && newItem is DemoTreeCategoryItem && oldItem.text == newItem.text && oldItem.expanded == newItem.expanded
    }
}