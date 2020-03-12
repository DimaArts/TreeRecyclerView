package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

open class DemoTreeCategoryItem(override var id: Int?, val text: String, subItems: List<RecyclerTreeViewItem> = listOf(), expanded: Boolean = false, level: Int): RecyclerTreeViewItem(subItems, expanded, level), ItemWithId