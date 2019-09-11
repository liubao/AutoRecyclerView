package com.liubao.autorecyclerview.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView


class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(o: Any?) {
        if (itemView is IBindDataView<*>) {
            (itemView as IBindDataView<Any>).setData(o)
        }
    }

}