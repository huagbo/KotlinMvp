package com.bobo.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.bobo.baselibrary.R

class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var isShowBack=true
    private var titleText:String?=null
    private var rightText:String?=null
    init {
        val typedArray=context.obtainStyledAttributes(attrs,R.styleable.HeaderBar)
        isShowBack=typedArray.getBoolean(R.styleable.HeaderBar_isShowBack,isShowBack)
        titleText=typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText=typedArray.getString(R.styleable.HeaderBar_rightText)

        initView()
        typedArray.recycle()
    }

    private fun initView() {
        View.inflate(context,R.layout.layout_head_bar,this)

    }
}