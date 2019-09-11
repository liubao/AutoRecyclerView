package com.liubao.autorecyclerview.test

import android.content.Context
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.liubao.autorecyclerview.view.IBindClickListenerView
import com.liubao.autorecyclerview.view.IBindDataView
import com.liubao.autorecyclerview.view.ViewClickCallBack

class MTextView(context: Context) : TextView(context), IBindDataView<String>,
    IBindClickListenerView<String> {
    override fun setClickListener(listener: ViewClickCallBack<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(t: String?) {
        setText(t)
    }

}