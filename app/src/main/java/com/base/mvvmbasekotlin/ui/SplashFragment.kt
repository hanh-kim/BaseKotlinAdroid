package com.base.mvvmbasekotlin.ui

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.BaseFragment

class SplashFragment : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.splash_fragment
    }

    override fun backFromAddFragment() {
    }

    override fun backPressed(): Boolean {
        return false
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        viewModel.getData()

        viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.v("ahuhu","data: ${it.userId}  ${it.title}")
        })
    }

    override fun initData() {
    }



    private lateinit var viewModel: SplashViewModel
}
