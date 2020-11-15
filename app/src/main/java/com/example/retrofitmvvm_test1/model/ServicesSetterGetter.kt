package com.example.retrofitmvvm_test1.model

import com.google.gson.annotations.SerializedName

data class ServicesSetterGetter (
    @SerializedName("title")
    val message: String? = null
)