package com.preetika.ussample.model


import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * subclasses to handle internal jsonarrays of content
 */
data class Skill(
    @SerializedName("languages")
    val languages: List<String>,
    @SerializedName("type")
    val type: String
)