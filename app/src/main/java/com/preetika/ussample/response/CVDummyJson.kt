package com.preetika.ussample.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * classes to handle main objects of raw data returned from gist api
 */

class CVDummyJson {

    @SerializedName("filename")
    @Expose
    var filename: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("raw_url")
    @Expose
    var rawUrl: String? = null
    @SerializedName("size")
    @Expose
    var size: Int? = null
    @SerializedName("truncated")
    @Expose
    var truncated: Boolean? = null
    @SerializedName("content")
    @Expose
    var content: String? = null

}