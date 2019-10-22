package com.preetika.ussample.retrofit

/**
 * @author Preetika Kaur
 * Service class to call the api
 */
object GitHubCVService {

    val gitHubService: GithubApiCall
        get() = RetrofitClient.client.create(GithubApiCall::class.java)
}