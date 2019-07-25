package com.bobo.baselibrary.common

import android.app.Application
import com.bobo.baselibrary.injection.component.AppComponent
import com.bobo.baselibrary.injection.component.DaggerAppComponent
import com.bobo.baselibrary.injection.module.AppModule

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    lateinit var appComponent: AppComponent
    private fun initAppInjection() {
        appComponent= DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}