package com.liubao.mylibrary.model


class MBaseModel : IBaseModel {
    override fun getViewClass(): Class<*>? {
        return clazz
    }

    override fun getData(): Any? {
        return any
    }

    var any: Any? = null
    var clazz: Class<*>? = null

    constructor(clazz: Class<*>, `object`: Any) {
        this.clazz = clazz
        this.any = `object`
    }

    constructor  () {

    }
}
