package ru.dimaarts.treerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.dimaarts.treerecyclerview.demorecyclertreeadapter.DemoTreeAdapter
import ru.dimaarts.treerecyclerview.demorecyclertreeadapter.DemoTreeSelectableItem
import ru.dimaarts.treerecyclerview.demorecyclertreeadapter.DemoTreeTopLevelItem
import ru.dimaarts.treerecyclerviewlibrary.recyclertreeadapter.RecyclerTreeViewItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerTreeView = findViewById<RecyclerView>(R.id.demo_tree_recycler)
        recyclerTreeView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val items: ArrayList<RecyclerTreeViewItem> = arrayListOf()
        var item: RecyclerTreeViewItem? = null

        var subItems: ArrayList<RecyclerTreeViewItem> = arrayListOf(
            DemoTreeSelectableItem(2, "File 2", level = 1),
            DemoTreeSelectableItem(3, "File 3", level = 1),
            DemoTreeSelectableItem(4, "File 4", level = 1)
        )

        item = DemoTreeTopLevelItem(0, "Catalog 1", subItems, 0)
        items.add(item)

        subItems = arrayListOf(
            DemoTreeSelectableItem(5, "File 5", level = 1),
            DemoTreeSelectableItem(6, "File 6", level = 1),
            DemoTreeSelectableItem(7, "File 7", level = 1),
            DemoTreeSelectableItem(8, "File 8", level = 1),
            DemoTreeSelectableItem(9, "File 9", level = 1),
            DemoTreeSelectableItem(10, "File 10", level = 1),
            DemoTreeSelectableItem(11, "File 11", level = 1)
        )

        item = DemoTreeTopLevelItem(21, "Catalog 2", subItems, 0)
        items.add(item)

        item = DemoTreeTopLevelItem(12, "Catalog 3", arrayListOf(), 0)
        items.add(item)

        val subItems2 = arrayListOf(
            DemoTreeSelectableItem(18, "File 18", level = 2),
            DemoTreeSelectableItem(19, "File 19", level = 2),
            DemoTreeSelectableItem(20, "File 20", level = 2)
        )

        subItems = arrayListOf(
            DemoTreeSelectableItem(13, "File 13", level = 1),
            DemoTreeSelectableItem(14, "File 14", level = 1),
            DemoTreeSelectableItem(15, "File 15", level = 1),
            DemoTreeSelectableItem(16, "File 16", subItems2, 1)
        )

        item = DemoTreeTopLevelItem(17, "Catalog 4", subItems, 0)
        items.add(item)

        recyclerTreeView.adapter = DemoTreeAdapter(items)
    }
}
