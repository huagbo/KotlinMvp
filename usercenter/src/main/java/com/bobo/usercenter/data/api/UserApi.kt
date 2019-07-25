package com.bobo.usercenter.data.api

import com.bobo.baselibrary.data.protocal.BaseResp
import com.bobo.usercenter.data.protocal.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>
}