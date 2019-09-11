package com.liubao.autorecyclerview.view


interface IBindClickListenerView<T> {
    fun setClickListener(listener: ViewClickCallBack<T>)
}
