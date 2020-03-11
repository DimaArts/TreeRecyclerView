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
        var subItems: ArrayList<RecyclerTreeViewItem> = arrayListOf()
        var subItem: RecyclerTreeViewItem? = null
        subItem = DemoTreeSelectableItem(1, "File 1")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(2, "File 2")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(3, "File 3")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(4, "File 4")
        subItems.add(subItem)
        item = DemoTreeTopLevelItem(0, "Catalog 1", subItems)
        items.add(item)

        subItems = arrayListOf()
        subItem = DemoTreeSelectableItem(5, "File 5")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(6, "File 6")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(7, "File 7")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(8, "File 8")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(9, "File 9")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(10, "File 10")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(11, "File 11")
        subItems.add(subItem)
        item = DemoTreeTopLevelItem(21, "Catalog 2", subItems)
        items.add(item)

        subItems = arrayListOf()
        item = DemoTreeTopLevelItem(12, "Catalog 3", subItems)
        items.add(item)

        subItems = arrayListOf()
        subItem = DemoTreeSelectableItem(13, "File 13")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(14, "File 14")
        subItems.add(subItem)
        subItem = DemoTreeSelectableItem(15, "File 15")
        subItems.add(subItem)

        var subItems2: ArrayList<RecyclerTreeViewItem> = arrayListOf()
        subItem = DemoTreeSelectableItem(18, "File 18")
        subItems2.add(subItem)
        subItem = DemoTreeSelectableItem(19, "File 19")
        subItems2.add(subItem)
        subItem = DemoTreeSelectableItem(20, "File 20")
        subItems2.add(subItem)

        subItem = DemoTreeSelectableItem(16, "File 16", subItems2)
        subItems.add(subItem)
        item = DemoTreeTopLevelItem(17, "Catalog 17", subItems)
        items.add(item)

        recyclerTreeView.adapter = DemoTreeAdapter(items)
    }
}
