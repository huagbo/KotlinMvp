package com.bobo.baselibrary.ext

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.bobo.baselibrary.data.protocal.BaseResp
import com.bobo.baselibrary.rx.BaseFunc
import com.bobo.baselibrary.rx.BaseFuncBoolean
import com.bobo.baselibrary.rx.BaseObserver
import com.bobo.baselibrary.widgets.DefaultTextWatcher
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())
}
fun <T> Observable<BaseResp<T>>.convertToBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(block: () -> Unit) {
    this.setOnClickListener {
        block()
    }
}

fun Button.enable(editText: EditText,method:()->Boolean){
    val btn=this
    editText.addTextChangedListener(object : DefaultTextWatcher() {
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            btn.isEnabled=method()
        }
    })
}
fun View.setVisible(visible:Boolean){
    this.visibility=if (visible) View.VISIBLE else View.GONE
}