package com.bobo.baselibrary.ext

import android.view.View
import com.bobo.baselibrary.data.protocal.BaseResp
import com.bobo.baselibrary.rx.BaseFunc
import com.bobo.baselibrary.rx.BaseFuncBoolean
import com.bobo.baselibrary.rx.BaseObserver
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