package com.cjinle.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TestRetrofit {
    fun run() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.56.101/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}