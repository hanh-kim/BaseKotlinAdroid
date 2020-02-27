package com.base.mvvmbasekotlin.ui

import android.util.Log
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.adapter.SearchAdapter
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.base.adapter.EndlessLoadingRecyclerViewAdapter
import com.base.mvvmbasekotlin.entity.User
import kotlinx.android.synthetic.main.splash_fragment.*

class SplashFragment : BaseFragment(),EndlessLoadingRecyclerViewAdapter.OnLoadingMoreListener {
    private lateinit var searchAdapter: SearchAdapter

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
        initAdapter()
        viewModel.getData()
        viewModel.data.observe(viewLifecycleOwner, Observer {
            handleLoadMoreResponse(it)
        })
    }

    override fun initData() {
    }

    override fun getListResponse(data: MutableList<*>?, isRefresh: Boolean, canLoadmore: Boolean) {
        searchAdapter.enableLoadingMore(canLoadmore)
        searchAdapter.hideLoadingItem()
        searchAdapter.addModels(data as List<User>,false)
    }

    private fun initAdapter() {
        searchAdapter = SearchAdapter(context!!)
        searchAdapter.setLoadingMoreListener(this)
        rcv.adapter = searchAdapter
    }

    override fun onLoadMore() {
        searchAdapter.showLoadingItem(true)
        viewModel.getData()
    }

    private lateinit var viewModel: SplashViewModel
}
