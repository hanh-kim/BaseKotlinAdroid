package com.base.mvvmbasekotlin.network


import com.base.mvvmbasekotlin.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiInterface {

    @GET
    fun getDataUser(@Url url: String): Single<User>
}
