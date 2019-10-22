package com.preetika.ussample.model


import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * Class created to handle Pojo of main content
 *
 */
data class Data(
    @SerializedName("data")
    val `data`: DataX
)