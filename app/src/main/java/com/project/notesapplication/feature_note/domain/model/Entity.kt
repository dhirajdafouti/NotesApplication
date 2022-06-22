package com.project.notesapplication.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.PrimaryKey

data class Entity(
    val title:String,
    val content:String,
    val timestamp: Long,
    val color:Int,
    @PrimaryKey val id:Int?=null
){
    companion object{
     val noteColors= listOf(Color.Black, Color.Red,Color.Green,Color.Blue)
    }
}
