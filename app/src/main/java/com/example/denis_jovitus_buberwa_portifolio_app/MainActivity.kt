package com.example.denis_jovitus_buberwa_portifolio_app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.denis_jovitus_buberwa_portifolio_app.ui.theme.Denis_Jovitus_Buberwa_Portifolio_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Denis_Jovitus_Buberwa_Portifolio_AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val colorList = listOf(Color(0xFF421fdf), Color(0xFF0c22de))
    val context = LocalContext.current
    val state = rememberScrollState()
    val height = LocalConfiguration.current.screenHeightDp.dp - 80.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(colorList))
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.desenho),
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .padding(0.dp),
            contentScale = ContentScale.FillBounds
        )

        // Main content
        Content(state)
    }
}

@Composable
fun Content(state: ScrollState) {
    val context = LocalContext.current

    // Profile Section
    Header()

    // About Section
    AboutMe()

    // Projects Section
    ProjectSection(state)

    // Contact Section
    ContactSection(context)
}

@Composable
fun Header() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.denisjb),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Denis Buberwa",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.White
        )
    }
}

@Composable
fun AboutMe() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "About Me",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = "Hey, welcome! My name is Denis Buberwa, and I am a final-year Computer Science student. " +
                    "I have a deep passion for cybersecurity, ethical hacking, and programming. " +
                    "I'm also interested in graphics design (Blender) and mobile & web development. " +
                    "In my projects, I use different programming languages, and I love building Android apps with Kotlin " +
                    "and React Native, as well as using Spring Boot for backend development and React for frontend Web. " +
                    "Currently, I'm working on a Note App using Kotlin Multiplatform Mobile (KMM) with Clean Architecture.",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ProjectSection(state: ScrollState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state)
            .padding(16.dp)
    ) {
        Text(
            text = "My Projects",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )

        // Add your project content here (Image, Description, etc.)
    }
}

@Composable
fun ContactSection(context: Context) {
    val sendEmail = {
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_EMAIL, arrayOf("denisjovitusbuberwa@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Hey, I came from your portfolio")
            type = "text/plain"
        }, null)
        context.startActivity(share)
    }

    val clickGit = {
        context.startActivity(
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse("https://github.com/Denis-Jovith")
            }
        )
    }

    val clickLinkedin = {
        context.startActivity(
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse("https://www.linkedin.com/in/denis-buberwa-555b09258/")
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { clickGit() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4285F4)),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "GitHub", color = Color.White)
        }
        Button(
            onClick = { clickLinkedin() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072b1)),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "LinkedIn", color = Color.White)
        }
        Button(
            onClick = { sendEmail() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFdb4437)),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Email", color = Color.White)
        }
    }
}
