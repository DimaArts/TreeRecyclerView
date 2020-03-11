package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import android.view.View
import android.widget.CheckBox
import ru.dimaarts.treerecyclerview.R
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewHolder
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoFileTreeViewHolder(itemView: View): RecyclerTreeViewHolder(itemView) {
    private val checkBox = itemView.findViewById<CheckBox>(R.id.checkbox)

    override fun bind(item: RecyclerTreeViewItem) {
        super.bind(item)
        if(item is DemoTreeSelectableItem) {
            checkBox.text = item.text
            checkBox.isChecked = item.expanded
        }
    }

    override fun onExpand(item: RecyclerTreeViewItem, expanded: Boolean) {
        checkBox.isChecked = expanded
    }
}