package com.example.profilepracticeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.profilepracticeapp.domain.model.Id
import com.example.profilepracticeapp.domain.model.Result
import com.example.profilepracticeapp.presentation.screen.DisplayProfiles
import com.example.profilepracticeapp.presentation.screen.ProfileDetails
import com.example.profilepracticeapp.presentation.viewmodel.ProfileViewModel
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(navController: NavHostController, viewModel: ProfileViewModel) {

//    @Serializable
//    data class UserId(val id: Id)

//    @Serializable
//    object ProfileList(val id: Id)


    NavHost(navController, startDestination = "profileList" ) {
        composable("profileList") {
            DisplayProfiles(viewModel)
        }
        composable("profileDetails"){
            ProfileDetails()
        }
    }

}