package com.example.recyclerview_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_02.adapter.RecyclerViewAdapter
import com.example.recyclerview_02.bean.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mDataList: ArrayList<Data>? = ArrayList()

    //一个小知识点,当列表为空时赋值0
    private var mSize = mDataList?.size ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_use.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        for (i in 0..10) {
            val data =
                Data(i, "message$i", "data$i")
            mDataList?.add(data)
        }
        rv_use.adapter = RecyclerViewAdapter(mDataList,this)
    }
}