package com.base.mvvmbasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.base.mvvmbasekotlin.base.BaseActivity
import com.base.mvvmbasekotlin.ui.SplashFragment
import com.base.mvvmbasekotlin.ui.SplashViewModel

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
