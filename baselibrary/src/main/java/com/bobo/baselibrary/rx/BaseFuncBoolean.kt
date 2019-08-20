package com.bobo.baselibrary.rx

import com.bobo.baselibrary.common.ResultCode
import com.bobo.baselibrary.data.protocal.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFuncBoolean<T>:Function<BaseResp<T>,Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        return if(t.status!= ResultCode.SUCCESS){
             Observable.error(BaseException(t.status,t.message))
        }else{
            Observable.just(true)
        }
    }
}
