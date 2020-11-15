package com.example.retrofitmvvm_test1.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm_test1.model.ServicesSetterGetter
import com.example.retrofitmvvm_test1.network.client.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getServices()

        /*call.enqueue(object : Callback<ServicesSetterGetter> {
            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
                Log.d("Failed : ", t.message.toString())
            }

            override fun onResponse(call: Call<ServicesSetterGetter>, response: Response<ServicesSetterGetter>) {
                Log.d("Success : ", response.body().toString())
                val data = response.body()
                val msg = data!!.message
                serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })*/

        call.enqueue(object : Callback<List<ServicesSetterGetter>> {
            override fun onFailure(call: Call<List<ServicesSetterGetter>>, t: Throwable) {
                Log.d("Failed : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<ServicesSetterGetter>>,
                response: Response<List<ServicesSetterGetter>>) {
                Log.d("Success : ", response.body().toString())
                val data = response.body()
                val msg = data!!.get(6).message
                serviceSetterGetter.value = ServicesSetterGetter(msg)
            }
        })
        return serviceSetterGetter
    }
}