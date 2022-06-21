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
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainActivity : ComponentActivity() {

    private val logger: Logger = LoggerFactory.getLogger(MainActivity::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.info("The MainActivity Instance Created")
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
