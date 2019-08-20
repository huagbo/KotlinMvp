package com.bobo.baselibrary.rx

import com.bobo.baselibrary.common.ResultCode
import com.bobo.baselibrary.data.protocal.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunc<T>: Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        return if(t.status!=ResultCode.SUCCESS){
            Observable.error(BaseException(t.status,t.message))
        }else{
            Observable.just(t.data)
        }
    }
}