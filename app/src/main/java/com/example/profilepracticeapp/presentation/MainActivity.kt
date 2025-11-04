package com.example.profilepracticeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.profilepracticeapp.presentation.screen.DisplayProfiles
import com.example.profilepracticeapp.presentation.viewmodel.ProfileViewModel

// Profile details will be restricted based on your

class MainActivity : ComponentActivity() {

    val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

//            val NavGraph = AppNavGraph

            DisplayProfiles(viewModel)
        }
    }
}

