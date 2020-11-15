package com.example.retrofitmvvm_test1.network.api

import com.example.retrofitmvvm_test1.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getServices() : Call<List<ServicesSetterGetter>>
}

