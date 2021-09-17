package com.base.mvvmbasekotlin.ui.home

import android.os.Bundle
import android.util.Log
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.extension.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel


    override fun backFromAddFragment() {
        //cho data tra ve tu fragment khac
    }

    override val layoutId: Int
        get() = R.layout.home_fragment

    override fun initView() {
        arguments?.let {
            if(it.containsKey("splash")){
                val splashString = it.getString("splash")
                Log.v("myLog","splash data ${splashString}")
            }
        }
    }

    override fun initData() {
    }

    override fun initListener() {
        
    }

    override fun backPressed(): Boolean {
        getVC().backFromAddFragment()
        return false
    }
}