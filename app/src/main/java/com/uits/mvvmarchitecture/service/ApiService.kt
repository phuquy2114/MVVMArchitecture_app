package com.uits.mvvmarchitecture.service

import com.uits.mvvmarchitecture.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ApiService
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/
interface ApiService {

    @GET("top-headlines")
    fun getNewsList(
        @Query("sources") newsSource: String,
        @Query("apiKey") apiKey: String
    ): Single<List<User>>

}