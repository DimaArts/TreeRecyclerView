package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.dimaarts.treerecyclerviewlibrary.utils.Utils

abstract class RecyclerTreeAdapter<T: RecyclerTreeViewHolder>(protected var items: ArrayList<RecyclerTreeViewItem>): RecyclerView.Adapter<T>() {
    override fun getItemCount(): Int {
        return flatVisibleItems.size
    }

    abstract fun getDiffUtilCallback(newItems: ArrayList<RecyclerTreeViewItem>): RecyclerTreeViewDiffUtilCallback

    protected val flatVisibleItems: List<RecyclerTreeViewItem> get() {
        return Utils.getFlatVisibleItems(items)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bind(flatVisibleItems[position])
        holder.onClickListener = {
            val item = findItem(it)
            if(item!=null) {
                holder.onExpand(item, !item.expanded)
                if (item.expanded) collapseItem(item)
                else expandItem(item)
            }
        }
    }

    private fun findItem(item: RecyclerTreeViewItem): RecyclerTreeViewItem? {
        for (item1 in flatVisibleItems) {
            if(areItemsTheSame(item, item1)) return item1
        }
        return null
    }

    private fun updateExpand(item: RecyclerTreeViewItem, expanded: Boolean) {
        val clonedTree = items.copyTreeWithChangeExpand(item, expanded)
        updateItems(clonedTree)
    }

    protected fun expandItem(item: RecyclerTreeViewItem) {
        updateExpand(item,true)
    }

    protected fun collapseItem(item: RecyclerTreeViewItem) {
        updateExpand(item,false)
    }

    fun updateItems(newItems: ArrayList<RecyclerTreeViewItem>) {
        val treeDiffResult = DiffUtil.calculateDiff(getDiffUtilCallback(newItems))
        items = newItems
        treeDiffResult.dispatchUpdatesTo(this)
    }

    fun ArrayList<RecyclerTreeViewItem>.copyTree(): ArrayList<RecyclerTreeViewItem> {
        return cloneTree(this, null)
    }

    private fun ArrayList<RecyclerTreeViewItem>.copyTreeWithChangeExpand(item: RecyclerTreeViewItem, expanded: Boolean): ArrayList<RecyclerTreeViewItem> {
        return cloneTree(this, item, expanded)
    }

    abstract fun areItemsTheSame(item1: RecyclerTreeViewItem?, item2: RecyclerTreeViewItem?): Boolean

    private fun cloneTree(list: List<RecyclerTreeViewItem>, expandedItem: RecyclerTreeViewItem?, expanded: Boolean = false): ArrayList<RecyclerTreeViewItem> {
        val clone: ArrayList<RecyclerTreeViewItem> = ArrayList(list.size)
        for (item in list) {
            val cloned = item.clone()
            if(areItemsTheSame(item, expandedItem)) cloned.expanded = expanded
            val clonedSubItems = cloneTree(item.subItems, expandedItem, expanded)
            cloned.subItems = clonedSubItems
            clone.add(cloned)
        }
        return clone
    }


}