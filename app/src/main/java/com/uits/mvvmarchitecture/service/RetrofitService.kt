package com.uits.mvvmarchitecture.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * TODO : Object
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/
class RetrofitService {




    companion object {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass)
        }
    }


}