package com.example.denis_jovitus_buberwa_portifolio_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactFormScreen(){
    Column (modifier = Modifier.fillMaxSize()
        .padding(16.dp)
    ) {
        Text(text = "Contact Me", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Name")},
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = "",
            onValueChange = {},
            label = {Text("Email")},
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextField(
            value = "",
            onValueChange = {},
            label = {Text("Message")},
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Button(onClick ={}) {
            Text(text = "Send Message")
        }
    }
}