package com.bobo.usercenter.data.repository

import com.bobo.baselibrary.data.net.RetrofitFactory
import com.bobo.baselibrary.data.protocal.BaseResp
import com.bobo.usercenter.data.api.UserApi
import com.bobo.usercenter.data.protocal.RegisterReq
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
            .register(RegisterReq(mobile, pwd, verifyCode))
    }
}