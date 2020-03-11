package ru.dimaarts.treerecyclerviewlibrary.utils

import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

object Utils {
    private fun addToFlatList(items: List<RecyclerTreeViewItem>, list: ArrayList<RecyclerTreeViewItem>) {
        items.forEach {
            list.add(it)
            if(it.expanded)
                addToFlatList(
                    it.subItems,
                    list
                )
        }
    }

    fun getFlatVisibleItems(items: ArrayList<RecyclerTreeViewItem>): List<RecyclerTreeViewItem> {
        val flatList = arrayListOf<RecyclerTreeViewItem>()
        addToFlatList(
            items,
            flatList
        )
        return flatList
    }
}