package com.example.kaamatangreetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaamatanGreetingCard()
        }
    }
}

@Composable
fun KaamatanGreetingCard() {

    // List of images (make sure these match your drawable file names)
    val images = listOf(
        R.drawable.kaamatan1,
        R.drawable.kaamatan2,
        R.drawable.kaamatan3,
        R.drawable.kaamatan4
    )

    // List of greeting texts for each image
    val greetings = listOf(
        "M1 - Kotobian Tadau Tagaze do Kaamatan.",
        "M2 - Happy Harvest Festival!",
        "M3 - Selamat Menyambut Pesta Kaamatan!",
        "M4 - 丰收节快乐!"
    )

    // Track the current index
    var currentIndex by remember { mutableStateOf(0) }

    // Main layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Created by text at the top
        Text(
            text = "Created by Amri",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image Composable
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = "Kaamatan Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text Composable
        Text(
            text = greetings[currentIndex],
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Previous Button
            Button(
                onClick = {
                    // Go to previous, wrap around if at the beginning
                    currentIndex = if (currentIndex > 0) currentIndex - 1
                    else images.size - 1
                }
            ) {
                Text(text = "Previous")
            }

            // Next Button
            Button(
                onClick = {
                    // Go to next, wrap around if at the end
                    currentIndex = if (currentIndex < images.size - 1) currentIndex + 1
                    else 0
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}