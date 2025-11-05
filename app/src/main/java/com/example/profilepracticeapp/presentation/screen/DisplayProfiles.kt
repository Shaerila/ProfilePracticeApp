package com.example.profilepracticeapp.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.profilepracticeapp.presentation.viewmodel.ProfileViewModel

// Initial display of the profiles

@Composable
fun DisplayProfiles(viewModel: ProfileViewModel) {


    val profileInformation by viewModel.userInformation.collectAsState()

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(0.dp,40.dp,0.dp, 0.dp),
        )
    {
        items(profileInformation) {
            profile -> ProfileCard(profile)

            Spacer(Modifier.height(10.dp))
        }
    }

}