package com.example.profilepracticeapp.data.repository

import com.example.profilepracticeapp.data.api.ProfileWebService
import com.example.profilepracticeapp.domain.model.RandomUserProfile
import com.example.profilepracticeapp.domain.model.Result

class ProfileRepository(val webService: ProfileWebService = ProfileWebService()) {

    // I believe here id be using the webservice to update the repository as my S.S.O.T.
    suspend fun getDataFromWebservice(): RandomUserProfile {

        return webService.getDataFromAPI()
    }

}