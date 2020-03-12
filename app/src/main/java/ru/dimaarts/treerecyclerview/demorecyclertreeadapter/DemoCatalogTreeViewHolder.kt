package ru.dimaarts.treerecyclerview.demorecyclertreeadapter

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import ru.dimaarts.treerecyclerview.R
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewHolder
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class DemoCatalogTreeViewHolder(itemView: View): RecyclerTreeViewHolder(itemView) {
    private val nameTextView = itemView.findViewById<TextView>(R.id.parent_category_text_view)
    private var arrow = itemView.findViewById<ImageView>(R.id.list_item_arrow)

    override fun bind(item: RecyclerTreeViewItem) {
        super.bind(item)
        if(item is DemoTreeCategoryItem) {
            val lp = itemView.layoutParams as? ViewGroup.MarginLayoutParams
            lp?.marginStart = itemView.resources.getDimensionPixelSize(R.dimen.tree_level_margin) * item.level
            itemView.layoutParams = lp

            nameTextView.text = item.text
            if(item.userExpand == true)
                animateExpand(ROTATE_ANIMATION_TIME_MS)
            else if(item.userCollapse == true)
                animateCollapse(ROTATE_ANIMATION_TIME_MS)
            else {
                if (item.expanded)
                    arrow.rotation = EXPANDED_DEGREES
                else
                    arrow.rotation = COLLAPSED_DEGREES
            }
            item.userCollapse = false
            item.userExpand = false
        }
    }

    override fun onExpand(item: RecyclerTreeViewItem, expanded: Boolean) {
        if(expanded) {
            item.userExpand = true
        }
        else {
            item.userCollapse = true
        }
    }

    private fun animateExpand(duration: Long) {
        arrow.animation?.cancel()
        val rotate = RotateAnimation(COLLAPSED_DEGREES, EXPANDED_DEGREES, RELATIVE_TO_SELF, PIVOT_CENTER, RELATIVE_TO_SELF, PIVOT_CENTER)
        rotate.duration = duration
        rotate.fillAfter = true
        arrow.animation = rotate
    }

    private fun animateCollapse(duration: Long) {
        arrow.animation?.cancel()
        val rotate = RotateAnimation(EXPANDED_DEGREES, COLLAPSED_DEGREES, RELATIVE_TO_SELF, PIVOT_CENTER, RELATIVE_TO_SELF, PIVOT_CENTER)
        rotate.duration = duration
        rotate.fillAfter = true
        arrow.animation = rotate
    }

    companion object {
        private const val ROTATE_ANIMATION_TIME_MS = 850L
        private const val PIVOT_CENTER = 0.5f
        private const val EXPANDED_DEGREES = 180f
        private const val COLLAPSED_DEGREES = 360f
    }
}