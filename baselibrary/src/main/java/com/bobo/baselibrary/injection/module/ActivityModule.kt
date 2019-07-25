package com.bobo.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import com.bobo.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity:Activity) {
    @Provides
    fun providesActivity(): Activity {
        return  activity
    }
}