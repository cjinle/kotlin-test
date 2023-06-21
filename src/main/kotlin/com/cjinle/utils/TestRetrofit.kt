package com.cjinle.utils

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val GITHUB_API_URL = "https://api.github.com"
class TestRetrofit {
    fun run() {
        val retrofit = Retrofit.Builder()
            .baseUrl(GITHUB_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val github = retrofit.create(Github::class.java)

        val call = github.contributors("cjinle", "draw.io")
        val contributors = call.execute().body()
        if (contributors !== null) {
            for (contributor in contributors) {
                println("login: ${contributor.login}, num: ${contributor.contributions}")
            }
        }

        val call2 = github.users("cjinle")
        val userInfo = call2.execute().body()
        if (userInfo !== null) {
            println(userInfo.login)
            println(userInfo.id)
            println(userInfo.url)
            println(userInfo.name)
            println(userInfo.location)
            println(userInfo.avatar)
        }

    }

}

data class Contributor(val login: String, val contributions: Int)

data class UserInfo(
    val login: String,
    val id: Int,
    val url: String,
    val name: String,
    val location: String,
    @SerializedName("avatar_url")
    val avatar: String,
)

interface Github {
    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<Contributor>>

    @GET("/users/{user}")
    fun users(@Path("user") user: String): Call<UserInfo>
}