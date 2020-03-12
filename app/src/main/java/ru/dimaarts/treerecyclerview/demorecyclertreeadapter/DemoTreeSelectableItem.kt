package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import ru.dimaarts.treerecyclerview.demorecyclertreeadapter.DemoTreeCategoryItem
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoTreeSelectableItem(id: Int?, text: String, subItems: List<RecyclerTreeViewItem> = listOf(), level: Int, expanded: Boolean = false): DemoTreeCategoryItem(id, text, subItems, expanded, level), ItemWithId {

}