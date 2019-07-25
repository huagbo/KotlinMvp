package com.bobo.usercenter.service

import io.reactivex.Observable


interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<String>
}