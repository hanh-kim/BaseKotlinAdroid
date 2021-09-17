package com.base.mvvmbasekotlin.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.Observer
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.adapter.SearchAdapter
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.base.permission.PermissionHelper
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import com.base.mvvmbasekotlin.extension.onAvoidDoubleClick
import com.base.mvvmbasekotlin.extension.toUpperCaseString
import com.base.mvvmbasekotlin.extension.toast
import com.base.mvvmbasekotlin.ui.home.HomeFragment
import kotlinx.android.synthetic.main.splash_fragment.*

@AndroidEntryPoint
class SplashFragment : BaseFragment() {
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(requireContext())
    }
    private val permissionHelper: PermissionHelper by lazy {
        PermissionHelper()
    }

    override val layoutId: Int
        get() = R.layout.splash_fragment

    override fun backFromAddFragment() {
        arguments?.let {args->
            if(args.containsKey("test")){
                val str = args.getString("test")
                Log.v("myLog","str : $str")
                args.clear()
            }
        }


    }

    override fun backPressed(): Boolean {
        return false
    }

    override fun initView() {
        initAdapter()
        viewModel.getData()
        viewModel.data.observe(viewLifecycleOwner, {
        })

    }

    override fun initData() {
        Log.v("myLog","str : button click 1")
        btn_test.onAvoidDoubleClick(2000) {
            Log.v("myLog","str : button click")
        }

        toast("hahaha")

    }

    override fun initListener() {
//        Looper.getMainLooper()?.let {
//            Handler(it).postDelayed({
//                getVC().addFragment(HomeFragment::class.java, Bundle().apply {
//                    putString("splash","splash value")
//                })
//            },1500)
//        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        permissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    private fun initAdapter() {

    }


    private val viewModel: SplashViewModel by viewModels()
}
