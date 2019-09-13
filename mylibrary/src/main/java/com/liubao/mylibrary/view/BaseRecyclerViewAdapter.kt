package com.liubao.mylibrary.view

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


abstract class BaseRecyclerViewAdapter<T>(protected var mContext: Context) :
    RecyclerView.Adapter<MViewHolder>() {

    protected var mList: MutableList<T> = ArrayList()
    protected var itemClickListener: RecyclerViewItemClickListener<T>? = null


    var list: MutableList<T>
        get() = mList
        set(mList) {
            this.mList = mList
        }

    interface RecyclerViewItemClickListener<T> {
        fun onRecyclerViewItemClick(v: View, model: T)
    }

    fun setRecyclerViewItemClickListener(itemClickListener: RecyclerViewItemClickListener<T>) {
        this.itemClickListener = itemClickListener
    }

    fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    fun clearAndAddAll(list: List<T>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    fun pointToList(list: MutableList<T>?) {
        if (list != null) {
            mList = list
        } else {
            mList.clear()
        }
        notifyDataSetChanged()
    }

    fun addAll(list: List<T>?) {
        if (list == null) {
            return
        }
        mList.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun getData(index: Int): T? {
        return if (index >= 0 && index < itemCount) {
            mList[index]
        } else null
    }

    override fun getItemCount(): Int {
        if (mList == null) return 0
        return mList.size
    }
}