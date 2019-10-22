package com.preetika.ussample.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * classes to handle main objects of raw data returned from gist api
 */

class GithubResp {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("forks_url")
    @Expose
    var forksUrl: String? = null
    @SerializedName("commits_url")
    @Expose
    var commitsUrl: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @SerializedName("git_pull_url")
    @Expose
    var gitPullUrl: String? = null
    @SerializedName("git_push_url")
    @Expose
    var gitPushUrl: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("files")
    @Expose
    var files: Files? = null
    @SerializedName("public")
    @Expose
    var public: Boolean? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("comments")
    @Expose
    var comments: Int? = null
    @SerializedName("user")
    @Expose
    var user: Any? = null
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String? = null
    @SerializedName("owner")
    @Expose
    var owner: Owner? = null
    @SerializedName("forks")
    @Expose
    var forks: List<Any>? = null
    @SerializedName("history")
    @Expose
    var history: List<History>? = null
    @SerializedName("truncated")
    @Expose
    var truncated: Boolean? = null


}


