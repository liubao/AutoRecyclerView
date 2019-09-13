package com.liubao.mylibrary.test

import android.content.Context
import android.widget.TextView
import com.liubao.mylibrary.view.IBindClickListenerView
import com.liubao.mylibrary.view.IBindDataView
import com.liubao.mylibrary.view.ViewClickCallBack

class MTextView(context: Context) : TextView(context), IBindDataView<String>,
    IBindClickListenerView<String> {
    override fun setClickListener(listener: ViewClickCallBack<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(t: String?) {
        setText(t)
    }

}