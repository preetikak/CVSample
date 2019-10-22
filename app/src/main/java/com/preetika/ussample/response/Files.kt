package com.preetika.ussample.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * classes to handle main objects of raw data returned from gist api
 */

class Files {

    @SerializedName("CVDummy.json")
    @Expose
    var cvDummyJson: CVDummyJson? = null

}


