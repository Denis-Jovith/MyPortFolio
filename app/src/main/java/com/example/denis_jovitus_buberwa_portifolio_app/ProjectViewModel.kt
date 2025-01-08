package com.example.denis_jovitus_buberwa_portifolio_app

import androidx.lifecycle.ViewModel

class ProjectViewModel : ViewModel(){
    val projectList = listOf(
        Project("1","Project1","Description for project 1",R.drawable.profile_image),
        Project("2", "Project 2", "Description for project 2", R.drawable.profile_image),

    )
}