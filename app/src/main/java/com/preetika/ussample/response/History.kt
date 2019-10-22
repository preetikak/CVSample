package com.preetika.ussample.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * classes to handle main objects of raw data returned from gist api
 */

class History {

    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("version")
    @Expose
    var version: String? = null
    @SerializedName("committed_at")
    @Expose
    var committedAt: String? = null
    @SerializedName("change_status")
    @Expose
    var changeStatus: ChangeStatus? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
}
