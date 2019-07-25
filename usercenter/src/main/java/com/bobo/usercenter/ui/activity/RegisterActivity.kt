package com.bobo.usercenter.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.bobo.baselibrary.ext.onClick
import com.bobo.baselibrary.ui.activity.BaseMvpActivity
import com.bobo.usercenter.R
import com.bobo.usercenter.injection.component.DaggerUserComponent
import com.bobo.usercenter.injection.module.UserModule
import com.bobo.usercenter.presenter.RegisterPresenter
import com.bobo.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity: BaseMvpActivity<RegisterPresenter>(),RegisterView {
    override fun injectComponent() {
        DaggerUserComponent.builder()
            .activityComponent(activityComponent)
            .build()
            .inject(this)
        mPresenter.mView=this
    }

    override fun onRegisterResult(result: String) {
        Toast.makeText(this,result,Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.onClick {
            mPresenter.register("13588888888","123456","111111")
        }

    }
}