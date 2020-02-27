package com.base.mvvmbasekotlin.network


import com.base.mvvmbasekotlin.base.entity.BaseListLoadMoreResponse
import com.base.mvvmbasekotlin.entity.User
import io.reactivex.Single
import retrofit2.http.*

interface ApiInterface {

    @GET("search")
    @Headers("Content-Type: application/json", "lang: vi")
    fun getDataUser(
        @Query("s") keyWord: String,
        @Query("page") page: Int
    ): Single<BaseListLoadMoreResponse<User>>
}
