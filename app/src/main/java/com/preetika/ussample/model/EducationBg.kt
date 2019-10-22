package com.preetika.ussample.model


import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * subclasses to handle internal jsonarrays of content
 */

data class EducationBg(
    @SerializedName("from")
    val from: String,
    @SerializedName("institute_name")
    val instituteName: String,
    @SerializedName("Major")
    val major: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("to")
    val to: String
)