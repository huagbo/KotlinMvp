package com.bobo.usercenter.presenter

import com.bobo.baselibrary.ext.execute
import com.bobo.baselibrary.presenter.BasePresenter
import com.bobo.baselibrary.rx.BaseObserver
import com.bobo.usercenter.presenter.view.RegisterView
import com.bobo.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {
    @Inject
    lateinit var userService: UserServiceImpl
    fun register(mobile: String, passWord: String, verifyCode: String) {
        userService.register(mobile, passWord, verifyCode)
            .execute(object : BaseObserver<String>() {
                override fun onNext(t: String) {
                    mView.onRegisterResult(t)
                }
            },lifecycleProvider)

    }
}