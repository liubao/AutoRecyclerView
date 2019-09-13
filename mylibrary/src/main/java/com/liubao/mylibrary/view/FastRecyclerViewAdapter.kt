package com.liubao.mylibrary.view

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.liubao.mylibrary.model.IBaseModel
import java.lang.reflect.InvocationTargetException
import java.util.HashMap


class FastRecyclerViewAdapter(context: Context) : BaseRecyclerViewAdapter<IBaseModel>(context) {

    var typeClassMap = SparseArray<Class<*>>()
    var classTypeMap = HashMap<Class<*>, Int>()
    var noneViewType: Int = 0

    private var index = -1

    init {
        register(MallNoneView::class.java)
        noneViewType = findType(MallNoneView::class.java)
    }

    private fun register(clazz: Class<*>?): Int {
        if (clazz == null) {
            return noneViewType
        }
        index++
        typeClassMap.put(index, clazz)
        classTypeMap[clazz] = index
        return index
    }

    protected fun getView(viewType: Int): View {
        val clazz = typeClassMap.get(viewType) ?: return MallNoneView(mContext)
        var view: View? = null
        try {
            val con = clazz.getDeclaredConstructor(Context::class.java)
            con.isAccessible = true
            view = con.newInstance(mContext) as View
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        if (view == null) {
            return MallNoneView(mContext)
        }
        view.setOnClickListener { v ->
            itemClickListener?.onRecyclerViewItemClick(v, v.tag as IBaseModel)
        }
        return view
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val listItem = mList[position]
        if (listItem != null) {
            holder.setData(listItem.getData())
            holder.itemView.tag = listItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        val listItem = mList[position]
        return if (listItem != null && listItem.getViewClass() != null) {
            return findType(listItem.getViewClass()!!)
        } else noneViewType
    }

    fun getItemViewTypeByClass(itemClass: Class<*>): Int {
        return findType(itemClass)
    }

    private fun findType(clazz: Class<*>): Int {
        return classTypeMap[clazz] ?: return register(clazz)
    }

    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MViewHolder {
        val view = getView(viewType)
        return MViewHolder(view)
    }

}
