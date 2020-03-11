package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import ru.dimaarts.treerecyclerview.demorecyclertreeadapter.DemoTreeCategoryItem
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoTreeTopLevelItem(id: Int?, text: String, subItems: List<RecyclerTreeViewItem> = listOf(), expanded: Boolean = false): DemoTreeCategoryItem(id, text, subItems, expanded) {

}