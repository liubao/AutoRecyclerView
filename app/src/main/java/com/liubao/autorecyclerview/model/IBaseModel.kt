package com.liubao.autorecyclerview.model

interface IBaseModel {

    fun getViewClass(): Class<*>?


    fun getData(): Any?
}
