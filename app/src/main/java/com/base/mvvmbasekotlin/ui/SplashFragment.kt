package com.base.mvvmbasekotlin.ui

import android.Manifest
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.base.mvvmbasekotlin.R
import com.base.mvvmbasekotlin.adapter.SearchAdapter
import com.base.mvvmbasekotlin.base.BaseFragment
import com.base.mvvmbasekotlin.base.adapter.EndlessLoadingRecyclerViewAdapter
import com.base.mvvmbasekotlin.base.adapter.RecyclerViewAdapter
import com.base.mvvmbasekotlin.base.permission.PermissionHelper
import com.base.mvvmbasekotlin.entity.User
import com.base.mvvmbasekotlin.extension.getViewModel
import com.base.mvvmbasekotlin.extension.onAvoidDoubleClick
import com.base.mvvmbasekotlin.extension.textChangedListener
import com.base.mvvmbasekotlin.extension.toast
import kotlinx.android.synthetic.main.splash_fragment.*

class SplashFragment : BaseFragment() {
    private lateinit var searchAdapter: SearchAdapter
    private val permissionHelper : PermissionHelper by lazy {
        PermissionHelper()
    }
    override fun getLayoutId(): Int {
        return R.layout.splash_fragment
    }

    override fun backFromAddFragment() {
    }

    override fun backPressed(): Boolean {
        return false
    }

    override fun initView() {
        viewModel = getViewModel(viewModelFactory)
        initAdapter()
        viewModel.getData()
        viewModel.data.observe(viewLifecycleOwner, Observer {
            handleLoadMoreResponse(it)
        })
    }

    override fun initData() {
        btn.onAvoidDoubleClick {
            permissionHelper.withFragment(this)
                .check(
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                .onSuccess(Runnable {
                    toast("success")
                })
                .onDenied(Runnable {
                    toast("onDenied")
                })
                .onNeverAskAgain(Runnable {
                    toast("onNeverAskAgain")
                })
                .run()
        }

        edt.textChangedListener {
            after {
                Log.v("ahuhu", "$it")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        permissionHelper.onRequestPermissionsResult(requestCode,permissions,grantResults)
    }

    override fun getListResponse(data: MutableList<*>?, isRefresh: Boolean, canLoadmore: Boolean) {
        rcv.enableLoadMore(canLoadmore)
        if (isRefresh) {
            rcv.refresh(data as List<User>)
        } else {
            rcv.addItem(data as List<User>)
        }
    }

    private fun initAdapter() {
        searchAdapter = SearchAdapter(context!!)
        rcv.setListLayoutManager(LinearLayoutManager.VERTICAL)
        rcv.setAdapter(searchAdapter)
        rcv.setOnLoadingMoreListener(object :
            EndlessLoadingRecyclerViewAdapter.OnLoadingMoreListener {
            override fun onLoadMore() {
                searchAdapter.showLoadingItem(true)
                viewModel.getData(false)
            }
        })
        rcv.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            viewModel.refreshData()
        })

        rcv.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(
                adapter: RecyclerView.Adapter<*>,
                viewHolder: RecyclerView.ViewHolder?,
                viewType: Int,
                position: Int
            ) {
                val data = searchAdapter.getItem(position, User::class.java)
                toast(data?.id.toString() + " " + data?.name)
            }
        })
    }


    private lateinit var viewModel: SplashViewModel
}
