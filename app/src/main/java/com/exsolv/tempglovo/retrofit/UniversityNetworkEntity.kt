package com.exsolv.tempglovo.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UniversityNetworkEntity(
    @SerializedName("domains")
    @Expose
    val domains: List<String>,
    @SerializedName("web_pages")
    @Expose
    val webPages: List<String>,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("alpha_two_code")
    @Expose
    val alphaTwoCode: String
)