package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

open class DemoTreeCategoryItem(var id: Int?, val text: String, subItems: List<RecyclerTreeViewItem> = listOf(), expanded: Boolean = false): RecyclerTreeViewItem(subItems, expanded)