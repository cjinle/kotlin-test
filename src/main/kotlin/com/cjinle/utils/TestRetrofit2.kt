package com.cjinle.utils

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.lang.model.type.NullType

class TestRetrofit2 {
    private val apiUrl = "http://192.168.56.101"

    fun run() {
        val retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        val result = api.index().execute().body()
        if (result !== null) {
            println("ret: ${result.ret}")
            println("msg: ${result.msg}")
            println("time: ${result.time}")
            println("data: ${result.data}")
        }

        val result2 = api.login().execute().body()
        if (result2 !== null) {
            println("ret: ${result2.ret}")
            println("msg: ${result2.msg}")
            println("time: ${result2.time}")
            println("data: ${result2.data}")
        }

    }
}

data class Result<T>(
    val ret: Int,
    val msg: String,
    val time: Int,
    val data: T?,
)

data class MemberInfo (
    @SerializedName("mid")
    val id: Int,
    @SerializedName("mnick")
    val nickname: String,
    @SerializedName("sex")
    val gender: Int,
    val money: Int,
)
interface ApiService {
    @GET("/test/api.php")
    fun index(): Call<Result<NullType>>

    @GET("/test/api.php?type=login")
    fun login(): Call<Result<MemberInfo>>
}

