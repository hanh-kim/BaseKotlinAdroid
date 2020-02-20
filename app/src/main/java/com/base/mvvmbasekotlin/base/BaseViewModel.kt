package com.base.mvvmbasekotlin.base

import androidx.lifecycle.ViewModel

import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    protected var mDisposable: CompositeDisposable? = null

    override fun onCleared() {
        super.onCleared()
        mDisposable?.clear()
    }
}
