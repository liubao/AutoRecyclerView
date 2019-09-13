package com.liubao.mylibrary.view


interface IBindClickListenerView<T> {
    fun setClickListener(listener: ViewClickCallBack<T>)
}
