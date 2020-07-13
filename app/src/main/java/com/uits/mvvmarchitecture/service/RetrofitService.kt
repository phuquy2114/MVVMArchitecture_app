package com.uits.mvvmarchitecture.service

import com.uits.baseproject.service.ApiClients
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * TODO : Object
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/
class RetrofitService : ApiClients() {

    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass)
        }
    }


}