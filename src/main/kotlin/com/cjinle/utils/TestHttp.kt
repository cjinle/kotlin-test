package com.cjinle.utils

import okhttp3.*
import java.io.IOException

const val API_URL = "https://www.51voa.com/Technology_Report_1.html"

class TestHttp {
    fun run() {
        println("test http start ... ")
        sync()
    }

    fun sync() {
        val client = OkHttpClient()
        var request = Request.Builder().url(API_URL).build()

        val response = client.newCall(request).execute()
        println(response.body?.string())
    }

    fun async() {
        val client = OkHttpClient()
        var request = Request.Builder().url(API_URL).build()

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("fail...")
            }

            override fun onResponse(call: Call, response: Response) {
                println("succ...")
                println(response.body?.string())
            }
        })
    }
}

