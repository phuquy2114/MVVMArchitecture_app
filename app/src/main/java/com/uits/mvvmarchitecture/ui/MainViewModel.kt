package com.uits.mvvmarchitecture.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uits.baseproject.service.ApiClients
import com.uits.mvvmarchitecture.base.BaseResponse
import com.uits.mvvmarchitecture.model.User
import com.uits.mvvmarchitecture.service.ApiService
import com.uits.mvvmarchitecture.service.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Main ViewModel
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/
class MainViewModel : ViewModel() {

    private val users = MutableLiveData<BaseResponse<List<User>>>()
    private val compositeDisposable = CompositeDisposable()
    private lateinit var newsApi: ApiService

    init {
//        newsApi = RetrofitService.createService(ApiService::class.java)
        ApiClients.init("https://newsapi.org/v2/")
        newsApi = ApiClients.createService(ApiService::class.java)
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(BaseResponse.loading(null))
        compositeDisposable.add(
            newsApi.getNewsList("","")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    users.postValue(BaseResponse.success(userList))
                }, { throwable ->
                    users.postValue(BaseResponse.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getNewsList(): LiveData<BaseResponse<List<User>>> {
        return users
    }
}