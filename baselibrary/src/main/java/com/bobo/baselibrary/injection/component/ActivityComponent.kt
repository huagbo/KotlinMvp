package com.bobo.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.bobo.baselibrary.injection.ActivityScope
import com.bobo.baselibrary.injection.module.ActivityModule
import com.bobo.baselibrary.injection.module.LifecycleProvideModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class] ,modules = [ActivityModule::class, LifecycleProvideModule::class])
interface ActivityComponent {

    fun activity():Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}