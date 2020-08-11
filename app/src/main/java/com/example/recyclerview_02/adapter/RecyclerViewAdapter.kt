package com.example.recyclerview_02.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_02.R
import com.example.recyclerview_02.bean.Data


class RecyclerViewAdapter(private var mDataList: ArrayList<Data>?, private var mContext: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    //一个小知识点,当列表为空时赋值0
    private var mSize = mDataList?.size ?: 0
    private var isCheckList: ArrayList<IsCheck>? = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_adapter_item, parent, false)
        return MyViewHolder.onCreateViewHolder(view as ViewGroup, viewType)
    }

    override fun getItemCount(): Int {
        for (i in 0..mSize) {
            val check = IsCheck()
            check.check = i==0
            isCheckList?.add(check)
        }
        return mSize
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_code).text =
            mDataList?.get(position)?.code.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_message).text =
            mDataList?.get(position)?.message
        holder.itemView.findViewById<TextView>(R.id.tv_data).text =
            mDataList?.get(position)?.data.toString()
        if (isCheckList?.get(position)?.check!!) {
            setTureCheck(position)
            holder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"))
        }
        holder.itemView.setOnClickListener {
            if (!isCheckList?.get(position)?.check!!) {
                setTureCheck(position)
                holder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"))
            } else {
                setFalseCheck(position)
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }
    }

    private fun setTureCheck(position:Int) {
        val check = IsCheck()
        check.check = true
        isCheckList?.set(position, check)
    }

    private fun setFalseCheck(position:Int) {
        val check = IsCheck()
        check.check = false
        isCheckList?.set(position, check)
    }

    class MyViewHolder(itemViews: View) : RecyclerView.ViewHolder(itemViews) {
        companion object {
            fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                return MyViewHolder(parent)
            }
        }
    }

    class IsCheck {
        var check = false
    }


}