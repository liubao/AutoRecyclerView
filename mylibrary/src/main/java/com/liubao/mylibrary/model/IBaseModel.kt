package com.liubao.mylibrary.model

interface IBaseModel {

    fun getViewClass(): Class<*>?


    fun getData(): Any?
}
