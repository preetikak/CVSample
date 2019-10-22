package com.preetika.ussample.model


import com.google.gson.annotations.SerializedName

/**
 * @author Preetika Kaur
 * subclass to handle main json objects
 */

data class DataX(
    @SerializedName("education_bg")
    val educationBg: List<EducationBg>,
    @SerializedName("name")
    val name: String,
    @SerializedName("skills")
    val skills: List<Skill>,
    @SerializedName("summary")
    val summary: String
)