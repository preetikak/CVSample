package com.preetika.ussample.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * @author Preetika Kaur
 * subclass to handle main json objects raw data returned from gist api
 */

class ChangeStatus {

    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("additions")
    @Expose
    var additions: Int? = null
    @SerializedName("deletions")
    @Expose
    var deletions: Int? = null

}
