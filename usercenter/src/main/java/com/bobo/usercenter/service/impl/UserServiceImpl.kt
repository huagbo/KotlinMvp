package com.bobo.usercenter.service.impl

import com.bobo.baselibrary.ext.convert
import com.bobo.usercenter.data.repository.UserRepository
import com.bobo.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() :UserService {
    @Inject
    lateinit var repository:UserRepository
    override fun register(mobile: String, pwd: String, verifyCode: String) : Observable<String> {
        return  repository.register(mobile,pwd,verifyCode).convert()
    }
}