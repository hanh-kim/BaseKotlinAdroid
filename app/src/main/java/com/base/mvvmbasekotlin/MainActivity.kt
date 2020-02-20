package com.base.mvvmbasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.base.mvvmbasekotlin.base.BaseActivity
import com.base.mvvmbasekotlin.ui.SplashFragment

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getFragmentContainerId(): Int {
        return R.id.container
    }

    override fun initView() {
        viewController?.addFragment(SplashFragment::class.java, null)
    }

    override fun initData() {
    }
}
