package com.bobo.usercenter.injection.component

import com.bobo.baselibrary.injection.PerComponentScope
import com.bobo.baselibrary.injection.component.ActivityComponent
import com.bobo.usercenter.injection.module.UserModule
import com.bobo.usercenter.ui.activity.RegisterActivity
import dagger.Component
@PerComponentScope
@Component(dependencies = [ActivityComponent::class],modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: RegisterActivity)
}