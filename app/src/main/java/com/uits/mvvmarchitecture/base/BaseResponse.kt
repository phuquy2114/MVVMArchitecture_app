package com.uits.mvvmarchitecture.base

/**
 * BaseResponse
 *
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/

class BaseResponse<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {

        fun <T> success(data: T?): BaseResponse<T> {
            return BaseResponse(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): BaseResponse<T> {
            return BaseResponse(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): BaseResponse<T> {
            return BaseResponse(Status.LOADING, data, null)
        }

    }
}