package com.example.profilepracticeapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.profilepracticeapp.domain.model.Result


@Composable
fun ProfileCard(profile: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp)
            .padding(5.dp),
//        onClick = , // When we click, we need to pass "profile.Id,value" for navigation
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .fillMaxHeight()
                    .padding(5.dp, 5.dp),
            )
            {
                // "Top Part" - First Name
                Text(profile.name.first, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(8.dp))

                // "Middle Part" - Last Name
                Text(profile.name.last, fontSize = 22.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(55.dp))

                // "Bottom Part" - Email
                Text(profile.email, fontSize = 16.sp)

            }

            // Image on right side of row in column 2
            Column(
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .fillMaxHeight()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Top
            )
            {
                AsyncImage(
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp),
                    model = profile.picture.medium,
                    contentDescription = null
                )
            }
        }
    }
}

