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
            DemoTreeSelectableItem(1, "File 1"),
            DemoTreeSelectableItem(2, "File 2"),
            DemoTreeSelectableItem(3, "File 3"),
            DemoTreeSelectableItem(4, "File 4")
        )

        item = DemoTreeTopLevelItem(0, "Catalog 1", subItems)
        items.add(item)

        subItems = arrayListOf(
            DemoTreeSelectableItem(5, "File 5"),
            DemoTreeSelectableItem(6, "File 6"),
            DemoTreeSelectableItem(7, "File 7"),
            DemoTreeSelectableItem(8, "File 8"),
            DemoTreeSelectableItem(9, "File 9"),
            DemoTreeSelectableItem(10, "File 10"),
            DemoTreeSelectableItem(11, "File 11")
        )

        item = DemoTreeTopLevelItem(21, "Catalog 2", subItems)
        items.add(item)

        item = DemoTreeTopLevelItem(12, "Catalog 3", arrayListOf())
        items.add(item)

        val subItems2 = arrayListOf(
            DemoTreeSelectableItem(18, "File 18"),
            DemoTreeSelectableItem(19, "File 19"),
            DemoTreeSelectableItem(20, "File 20")
        )

        subItems = arrayListOf(
            DemoTreeSelectableItem(13, "File 13"),
            DemoTreeSelectableItem(14, "File 14"),
            DemoTreeSelectableItem(15, "File 15"),
            DemoTreeSelectableItem(16, "File 16", subItems2)
        )

        item = DemoTreeTopLevelItem(17, "Catalog 4", subItems)
        items.add(item)

        recyclerTreeView.adapter = DemoTreeAdapter(items)
    }
}
