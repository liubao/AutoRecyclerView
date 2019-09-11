package com.liubao.autorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.liubao.autorecyclerview.model.MBaseModel
import com.liubao.autorecyclerview.test.MTextView
import com.liubao.autorecyclerview.view.FastRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = FastRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<MBaseModel>()
        for (i in 0..39) {
            list.add(MBaseModel(MTextView::class.java, i.toString()))
        }
        adapter.addAll(list)

    }
}
