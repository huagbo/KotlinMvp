package com.bobo.usercenter.injection.module

import com.bobo.usercenter.service.UserService
import com.bobo.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun providesUserService(service: UserServiceImpl):UserService{
        return service
    }
}