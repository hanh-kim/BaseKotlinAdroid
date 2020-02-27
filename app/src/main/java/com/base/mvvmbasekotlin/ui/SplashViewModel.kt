package com.base.mvvmbasekotlin.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.base.mvvmbasekotlin.base.BaseViewModel
import com.base.mvvmbasekotlin.entity.User
import com.base.mvvmbasekotlin.network.Repository
import javax.inject.Inject

class SplashViewModel @Inject constructor(var repo: Repository) : BaseViewModel() {
    var data: MutableLiveData<User> = MutableLiveData()

    fun getData() {
        mDisposable.add(repo.getData().doOnSubscribe {

        }
            .subscribe(
                {
                    data.value = it
                },
                {
                    Log.v("ahuhu","error=> ${it.message}")
                }
            ))
    }
}
