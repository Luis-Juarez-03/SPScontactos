package com.example.spscontactos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.dotlottie.dlplayer.Mode
import com.example.spscontactos.ui.theme.SPScontactosTheme
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController
import com.lottiefiles.dotlottie.core.widget.DotLottieAnimation
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Show the splash screen using the SplashScreen API
        val splashScreen = this.installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            SPScontactosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    SplashContent()
                }
            }
        }

        // Add a delay to simulate some background task (e.g., loading resources)
        CoroutineScope(Dispatchers.Main).launch {
            delay(10000) // 2-second delay
            // After delay, navigate to MainActivity
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish SplashScreenActivity so it's not accessible again
        }
    }
}

@Composable
fun SplashContent() {
    LaunchedEffect(Unit) {
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Optional padding for spacing
        verticalArrangement = Arrangement.Center, // Centers content vertically
        horizontalAlignment = Alignment.CenterHorizontally // Centers content horizontally
    ) {
        // The animation fills all available space, respecting the text below
        DotLottiePreview(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ensures the animation fills available space
        )
        Spacer(modifier = Modifier.height(24.dp)) // Space between animation and text
        SplashData()
    }
}

@Preview
@Composable
fun DotLottiePreview(modifier: Modifier = Modifier) {
    DotLottieAnimation(
        source = DotLottieSource.Asset("animation.json"),
        autoplay = true,
        loop = true,
        modifier = modifier
            .fillMaxWidth()
            .height(0.dp) // Set this to zero as the `weight(1f)` handles the height
    )
}

@Composable
fun SplashData() {
    Text(
        text = "SPS Contactos",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        textAlign = TextAlign.Center, // Center-aligns text horizontally
        modifier = Modifier.fillMaxWidth() // Ensures text is centered
    )
    Text(
        text = "Luis Juarez",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center, // Center-aligns text horizontally
        modifier = Modifier.fillMaxWidth() // Ensures text is centered
    )
}
