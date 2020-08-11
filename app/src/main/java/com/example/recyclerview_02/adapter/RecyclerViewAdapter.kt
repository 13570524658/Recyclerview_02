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


class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    //一个小知识点,当列表为空时赋值0
    private var mDataList: ArrayList<Data>? = ArrayList()
    private var isCheckList: ArrayList<IsCheck>? = ArrayList()
    private lateinit var mContext: Context

    constructor(dataList: ArrayList<Data>?,conetxt:Context) : this() {
        mContext=conetxt
        mDataList=dataList
        isCheckList?.clear()
        for (i in 1..mDataList?.size!!) {
            val check = IsCheck()
            check.check = i == 0
            isCheckList?.add(check)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_adapter_item, parent, false)
        return MyViewHolder.onCreateViewHolder(view as ViewGroup, viewType)
    }

    override fun getItemCount(): Int {
        return mDataList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_code).text =
            mDataList?.get(position)?.code.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_message).text =
            mDataList?.get(position)?.message
        holder.itemView.findViewById<TextView>(R.id.tv_data).text =
            mDataList?.get(position)?.data.toString()
        if (isCheckList != null && isCheckList!!.size > 0) {
            if (isCheckList?.get(position)?.check==true) {
                holder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"))
            } else {
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

        holder.itemView.setOnClickListener {
            if (isCheckList != null && isCheckList!!.size > 0) {
                if (isCheckList?.get(position)?.check!!) {
                    setTureCheck(position)
                    holder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"))
                } else {
                    setTureCheck(position)
                    holder.itemView.setBackgroundColor(Color.parseColor("#03DAC5"))
                }
            }
            notifyDataSetChanged()
        }
    }

    private fun setTureCheck(position: Int) {
        isCheckList?.clear()
        for (i in 1..mDataList?.size!!) {
            val check = IsCheck()
            check.check = i == 0
            isCheckList?.add(check)
        }
        val check = IsCheck()
        check.check = true;
        isCheckList?.set(position, check);
    }

    private fun setFalseCheck(position: Int) {
        isCheckList?.clear()
        for (i in 1..mDataList?.size!!) {
            val check = IsCheck()
            check.check = i == 0
            isCheckList?.add(check)
        }
        val check = IsCheck()
        check.check = false;
        isCheckList?.set(position, check);
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