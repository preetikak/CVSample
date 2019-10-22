package com.preetika.ussample.retrofit

import com.preetika.ussample.response.CVDummyJson
import com.preetika.ussample.response.GithubResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Preetika KAur
 * Get query to hit the server request
 */
interface GithubApiCall {

    @GET("gists/89b423d00ae7b9b36c563dad43f75dc7")
    fun getData(): Call<GithubResp>

}
