package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

open class RecyclerTreeViewItem (var subItems: List<RecyclerTreeViewItem> = listOf(), var expanded: Boolean = false): Cloneable {
    var userExpand: Boolean? = null
    var userCollapse: Boolean? = null

    public override fun clone(): RecyclerTreeViewItem {
        return super.clone() as RecyclerTreeViewItem
    }
}