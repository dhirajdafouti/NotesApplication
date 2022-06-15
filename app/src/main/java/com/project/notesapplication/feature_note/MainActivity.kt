package com.project.notesapplication.feature_note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.project.notesapplication.ui.theme.NotesApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesApplicationTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)) {
                    Column {
                        Text(text = "Welcome to Notes Application...")
                    }

                }
            }
        }
    }
}
