package com.bobo.baselibrary.ui.activity

import android.os.Bundle
import com.bobo.baselibrary.common.BaseApplication
import com.bobo.baselibrary.injection.component.ActivityComponent
import com.bobo.baselibrary.injection.component.DaggerActivityComponent
import com.bobo.baselibrary.injection.module.ActivityModule
import com.bobo.baselibrary.injection.module.LifecycleProvideModule
import com.bobo.baselibrary.presenter.BasePresenter
import com.bobo.baselibrary.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

    }

    abstract fun injectComponent()

    lateinit var activityComponent: ActivityComponent
    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).appComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProvideModule(LifecycleProvideModule(this))
            .build()


    }
}