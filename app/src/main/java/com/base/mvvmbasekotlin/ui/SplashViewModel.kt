package com.base.mvvmbasekotlin.ui

import androidx.lifecycle.MutableLiveData
import com.base.mvvmbasekotlin.base.BaseViewModel
import com.base.mvvmbasekotlin.base.entity.BaseListLoadMoreResponse
import com.base.mvvmbasekotlin.entity.User
import com.base.mvvmbasekotlin.network.Repository
import javax.inject.Inject

class SplashViewModel @Inject constructor(var repo: Repository) : BaseViewModel() {
    var data: MutableLiveData<BaseListLoadMoreResponse<User>> = MutableLiveData()
    var pageIndex = 1
    fun getData(isRefresh:Boolean = true) {
        mDisposable.add(repo.getData(pageIndex).doOnSubscribe {
            data.value = BaseListLoadMoreResponse<User>().loading()
        }
            .subscribe(
                {
                    pageIndex++
                    data.value = BaseListLoadMoreResponse<User>().success(it.data,isRefresh,pageIndex<=it.totalPage)
                },
                {
                    data.value = BaseListLoadMoreResponse<User>().error(throwable = it)
                }
            ))
    }

    fun refreshData(){
        pageIndex = 1
        getData()
    }
}
