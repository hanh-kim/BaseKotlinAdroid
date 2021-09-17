package com.base.mvvmbasekotlin.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.base.mvvmbasekotlin.extension.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var context: Context) : ViewModel() {
    // TODO: Implement the ViewModel

    fun test(){
        context.toast("ahihihihihi")
    }
}