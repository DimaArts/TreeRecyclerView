package ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter

import androidx.recyclerview.widget.DiffUtil
import ru.dimaarts.treerecyclerviewlibrary.utils.Utils


abstract class RecyclerTreeAdapter<T : RecyclerTreeViewHolder>(protected var items: ArrayList<RecyclerTreeViewItem>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<T>() {
    override fun getItemCount(): Int {
        return flatVisibleItems.size
    }

    abstract fun getDiffUtilCallback(newItems: ArrayList<RecyclerTreeViewItem>): RecyclerTreeViewDiffUtilCallback

    protected val flatVisibleItems: List<RecyclerTreeViewItem>
        get() {
            return Utils.getFlatVisibleItems(items)
        }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bind(flatVisibleItems[position])
        holder.onClickListener = {
            val item = findItem(it)
            if (item != null) {
                holder.onExpand(item, !item.expanded)
                if (item.expanded) collapseItem(item)
                else expandItem(item)
            }
        }
    }

    private fun findItem(item: RecyclerTreeViewItem): RecyclerTreeViewItem? {
        for (item1 in flatVisibleItems) {
            if (areItemsTheSame(item, item1)) return item1
        }
        return null
    }

    private fun updateExpand(item: RecyclerTreeViewItem, expanded: Boolean) {
        val clonedTree = items.copyTreeWithChangeExpand(item, expanded)
        processExpand(clonedTree, item, expanded)
        updateItems(clonedTree)
    }

    protected open fun processExpand(
        clonedTree: ArrayList<RecyclerTreeViewItem>,
        item: RecyclerTreeViewItem,
        expanded: Boolean
    ) {

    }

    protected fun expandItem(item: RecyclerTreeViewItem) {
        updateExpand(item, true)
    }

    protected fun collapseItem(item: RecyclerTreeViewItem) {
        updateExpand(item, false)
    }

    fun updateItems(newItems: ArrayList<RecyclerTreeViewItem>) {
        val treeDiffResult = DiffUtil.calculateDiff(getDiffUtilCallback(newItems))
        items = newItems
        treeDiffResult.dispatchUpdatesTo(this)
    }

    fun ArrayList<RecyclerTreeViewItem>.copyTree(): ArrayList<RecyclerTreeViewItem> {
        return cloneTree(this, null)
    }

    private fun ArrayList<RecyclerTreeViewItem>.copyTreeWithChangeExpand(
        item: RecyclerTreeViewItem,
        expanded: Boolean
    ): ArrayList<RecyclerTreeViewItem> {
        return cloneTree(this, item, expanded)
    }

    abstract fun areItemsTheSame(
        item1: RecyclerTreeViewItem?,
        item2: RecyclerTreeViewItem?
    ): Boolean

    private fun cloneTree(
        list: List<RecyclerTreeViewItem>,
        expandedItem: RecyclerTreeViewItem?,
        expanded: Boolean = false
    ): ArrayList<RecyclerTreeViewItem> {
        val clone: ArrayList<RecyclerTreeViewItem> = ArrayList(list.size)
        for (item in list) {
            val cloned = item.clone()
            if (areItemsTheSame(item, expandedItem)) cloned.expanded = expanded
            val clonedSubItems = cloneTree(item.subItems, expandedItem, expanded)
            cloned.subItems = clonedSubItems
            clone.add(cloned)
        }
        return clone
    }

    fun ArrayList<RecyclerTreeViewItem>.firstOrNullInTree(func: (RecyclerTreeViewItem) -> Boolean): RecyclerTreeViewItem? {
        return firstOrNullInTreeInternal(this, func)
    }

    fun ArrayList<RecyclerTreeViewItem>.foreachInTree(func: (RecyclerTreeViewItem) -> Unit) {
        return foreachInTreeInternal(this, func)
    }

    private fun foreachInTreeInternal(
        tree: List<RecyclerTreeViewItem>,
        func: (RecyclerTreeViewItem) -> Unit
    ) {
        tree.forEach {
            func.invoke(it)
            foreachInTreeInternal(it.subItems, func)
        }
    }

    private fun firstOrNullInTreeInternal(
        tree: List<RecyclerTreeViewItem>,
        func: (RecyclerTreeViewItem) -> Boolean
    ): RecyclerTreeViewItem? {
        tree.forEach {
            val result = func.invoke(it)
            if (result) return it
            val foundItem = firstOrNullInTreeInternal(it.subItems, func)
            if (foundItem != null) return foundItem
        }
        return null
    }


}