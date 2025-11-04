package com.example.profilepracticeapp.data.api

import com.example.profilepracticeapp.domain.model.RandomUserProfile
import com.example.profilepracticeapp.domain.model.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ProfileWebService {

    private lateinit var api: ProfileAPI


    init {

        // https://randomuser.me/api/?results=10
        val base_URL = "https://randomuser.me"

        val retrofit = Retrofit.Builder()
            .baseUrl(base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        // 'api' of type ProfileAPI is set to the
        api = retrofit.create(ProfileAPI::class.java)

    }


    suspend fun getDataFromAPI(): RandomUserProfile{
        return api.getData()
    }




    interface ProfileAPI {

        // Make suspend function for making initial API call

        @GET("/api/?results=10")
        suspend fun getData(): RandomUserProfile
    }


}