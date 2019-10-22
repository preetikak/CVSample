package com.preetika.ussample.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Preetika Kaur
 * class returning retrofit object
 */

object RetrofitClient {

    private var mRetrofit: Retrofit? = null
    private val BASE_URL = "https://api.github.com/"
    val client: Retrofit
        get() {
            if (mRetrofit == null) {
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return mRetrofit!!
        }
}