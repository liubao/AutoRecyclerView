package com.liubao.mylibrary.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class MallNoneView : View,
    IBindDataView<Any>,
    IBindClickListenerView<Any> {
    override fun setData(t: Any?) {
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setClickListener(
        listener: ViewClickCallBack<Any>
    ) {
    }

}


